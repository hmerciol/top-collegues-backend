package dev.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.webapp.entity.Collegue;
import dev.webapp.entity.Vote;
import dev.webapp.repository.CollegueRepository;
import dev.webapp.service.CollegueValidator;
import dev.webapp.service.HistoriqueVotes;

@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class ColleguesController {

	@Autowired
	private CollegueRepository colRepo;
	@Autowired
	private CollegueValidator colVal;
	@Autowired
	private HistoriqueVotes histoVotes;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return colRepo.findAll();
	}

	@GetMapping(path = "/{pseudo}")
	public Collegue trouverCollegue(@PathVariable String pseudo) {
		return colRepo.findOne(pseudo);
	}

	@PostMapping
	public ResponseEntity<Collegue> creerCollegue(@RequestBody Collegue newCol) {
		if (colVal.valider(newCol)) {
			colRepo.save(newCol);
			return ResponseEntity.status(HttpStatus.CREATED).body(newCol);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newCol);
	}

	@PatchMapping(path = "/{pseudo}")
	public Collegue noterCollegue(@PathVariable String pseudo, @RequestBody String action) {
		Collegue collegue = colRepo.findOne(pseudo);
		if (collegue == null) {
			return null;
		}
		if (action.contains("aimer")) {
			collegue.setScore(collegue.getScore() + 10);
			action="aimer";
		}
		if (action.contains("detester")) {
			collegue.setScore(collegue.getScore() - 5);
			action="detester";
		}
		histoVotes.newVote(new Vote(collegue, action));
		colRepo.save(collegue);
		return collegue;
	}

	@DeleteMapping(path = "/{pseudo}")
	public Collegue supprimerCollegue(@PathVariable String pseudo) {
		Collegue collegue = colRepo.findOne(pseudo);
		if (collegue != null) {
			colRepo.delete(collegue);
		}
		return collegue;
	}

}
