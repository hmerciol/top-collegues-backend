package dev.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.webapp.entity.Collegue;
import dev.webapp.repository.CollegueRepository;
import dev.webapp.service.CollegueValidator;

@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class ColleguesController {

	@Autowired
	private CollegueRepository colRepo;
	@Autowired
	private CollegueValidator colVal;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return colRepo.findAll();
	}

	@PostMapping
	public Collegue creerCollegue(@RequestBody Collegue newCol) {
		if (colVal.valider(newCol)) {
			colRepo.save(newCol);
			return newCol;
		}
		return null;
	}

	@PatchMapping(path = "/{pseudo}")
	public Collegue noterCollegue(@PathVariable String pseudo, @RequestBody String action) {
		Collegue collegue = colRepo.findOne(pseudo);
		if (collegue == null) {
			return null;
		}
		if (action.contains("aimer")) {
			collegue.setScore(collegue.getScore() + 10);
		}
		if (action.contains("detester")) {
			collegue.setScore(collegue.getScore() - 5);
		}
		colRepo.save(collegue);
		return collegue;
	}

}
