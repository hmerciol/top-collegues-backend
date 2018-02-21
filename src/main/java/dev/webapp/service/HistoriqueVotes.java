package dev.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webapp.entity.Vote;
import dev.webapp.repository.VoteRepository;

@Service
public class HistoriqueVotes {

	@Autowired
	private VoteRepository voteRepo;
	
	public void newVote(Vote newVote) {
		voteRepo.save(newVote);
	}
	
	public List<Vote> getHistorique(Integer since) {
		List<Vote> historique = voteRepo.findAll();
		Vote sinceVote = historique.stream().filter(v -> v.getId().intValue() == since.intValue()).findFirst().orElse(null);
		if(sinceVote == null) {
			return new ArrayList<>();
		}
		return historique.subList(historique.indexOf(sinceVote),historique.size());
	}
	
	public List<Vote> getDefaultHistorique() {
		List<Vote> historique = voteRepo.findAll();
		if(historique.isEmpty()) {
			return new ArrayList<>();
		}else if(historique.size()<3) {
			return historique.subList(0, historique.size());
		}else {
			return historique.subList(historique.size()-3, historique.size());
		}
	}
	
	public Vote delete(Integer voteId) {
		Vote delVote = voteRepo.findOne(voteId);
		voteRepo.delete(delVote);
		return delVote;
	}

}
