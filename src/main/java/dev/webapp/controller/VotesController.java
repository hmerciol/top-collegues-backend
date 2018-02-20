package dev.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webapp.entity.Vote;
import dev.webapp.service.HistoriqueVotes;

@RestController
@CrossOrigin
@RequestMapping("/votes")
public class VotesController {

	@Autowired
	private HistoriqueVotes histoVotes;
	
	@GetMapping
	public List<Vote> historique(@RequestParam(value = "since", required = false) Integer voteId) {
		if(voteId == null) {
			return histoVotes.getDefaultHistorique();
		}
		return histoVotes.getHistorique(voteId);
	}
	
	@DeleteMapping
	public Vote retirerHistorique(@RequestParam(value = "since", required = true) Integer voteId) {
		return histoVotes.delete(voteId);
	}

}
