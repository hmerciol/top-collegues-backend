package dev.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.webapp.entity.Vote;

@Service
public class HistoriqueVotes {
	
	private List<Vote> historique = new ArrayList<>();
	
	public void newVote(Vote newVote) {
		historique.add(newVote);
	}
	
	public List<Vote> getHistorique(Integer since) {
		Vote sinceVote = historique.stream().filter(v -> v.getId().intValue() == since.intValue()).findFirst().orElse(null);
		if(sinceVote == null) {
			return new ArrayList<>();
		}
		return historique.subList(historique.indexOf(sinceVote),historique.size());
	}
	
	public List<Vote> getDefaultHistorique() {
		if(historique.isEmpty()) {
			return new ArrayList<>();
		}else if(historique.size()<3) {
			return historique.subList(0, historique.size());
		}else {
			return historique.subList(historique.size()-3, historique.size());
		}
	}

}
