package com.pakfro.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pakfro.languages.models.Language;
import com.pakfro.languages.repositories.LanguageRepository;


@Service
public class LanguageService {

	
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	// Get all the languages in the db
	
	public List<Language> allLangauges() {
		return this.langRepo.findAll();
	}
	
    // creates a language
    public Language createLanguage(Language lan) {
        return langRepo.save(lan);
    }
    
    
    // Get one language
	public Language getLang(Long id) {
		Optional<Language> oneLang = langRepo.findById(id);
		if(oneLang.isPresent()) {
			return oneLang.get();
		}else {

		return null;	
//		return this.langRepo.findById(id).orElse(null);
	}
	}
	
	
	// Update a language
	
	public Language updateLang(Long id,String name, String creator, Float currentversion) {
    	Language toUpdate = this.langRepo.findById(id).orElse(null);
    	if(toUpdate == null) {
    		return null;
    	}else {
    		
    		toUpdate.setCreator(creator);
    		toUpdate.setName(name);
    		toUpdate.setCurrentversion(currentversion);
    		
    		return this.langRepo.save(toUpdate);
    		
    	}	
    }
	
	public Language updateLang(Language lang) {
//		System.out.println(lang.toString());
		return this.langRepo.save(lang);
	}
	
	
	// Delete a language
	 public void deleteLang(Long id) {
	    	this.langRepo.deleteById(id);
	    }
}
