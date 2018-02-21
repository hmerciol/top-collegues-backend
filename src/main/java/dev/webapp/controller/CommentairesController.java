package dev.webapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webapp.entity.Commentaire;
import dev.webapp.repository.CollegueRepository;
import dev.webapp.repository.CommentaireRepository;

@RestController
@CrossOrigin
@RequestMapping("/commentaires")
public class CommentairesController {

	@Autowired
	private CommentaireRepository commentRepo;
	@Autowired
	private CollegueRepository colRepo;

	@GetMapping
	public List<Commentaire> tousLesCommentaires() {
		return commentRepo.findAll();
	}

	@GetMapping(path = "/{pseudo}")
	public List<Commentaire> getCommentaires(@PathVariable String pseudo) {
		return commentRepo.findAll().stream().filter(com -> com.getCollegue().getPseudo().equals(pseudo))
				.collect(Collectors.toList());
	}
	
	@PostMapping(path = "/{pseudo}")
	public Commentaire ajouterCommentaire(@PathVariable String pseudo, @RequestBody String comment) {
		Commentaire newCom = new Commentaire(colRepo.findOne(pseudo), comment);
		commentRepo.save(newCom);
		return newCom;
	}
	
	@DeleteMapping
	public Commentaire supprimerCommentaire(@RequestParam(value = "comment", required = true) Integer commId) {
		Commentaire delComm = commentRepo.findOne(commId);
		commentRepo.delete(delComm);
		return delComm;
	}

}
