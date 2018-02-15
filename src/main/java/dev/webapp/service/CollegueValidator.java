package dev.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webapp.entity.Collegue;
import dev.webapp.repository.CollegueRepository;

@Service
public class CollegueValidator implements EntityValidator {
	
	@Autowired
	private CollegueRepository colRepo;

	@Override
	public boolean valider(Object obj) {
		if(obj instanceof Collegue) {
			Collegue collegue = (Collegue) obj;
			
			// le pseudo doit etre valide
			if(collegue.getPseudo() == null) {
				return false;
			}
			
			// le pseudo ne doit pas etre deja pris
			return colRepo.findOne(collegue.getPseudo()) == null;
		}
		return false;
	}

}
