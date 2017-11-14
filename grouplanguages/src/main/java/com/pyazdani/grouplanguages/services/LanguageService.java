package com.pyazdani.grouplanguages.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyazdani.grouplanguages.models.Language;
import com.pyazdani.grouplanguages.repositories.*;

@Service
public class LanguageService {
	
//	private List<Language> languages = new ArrayList<Language>();
		
	private LanguageRepository languageRepository;
	
//	public List<Language> getLanguages() {
//	return languages;
//}
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepository = languageRepo;
	}
	
	public List<Language> getLanguages(){
        return languageRepository.findAll();
    }
	
//	public void addLanguage(Language lang) {
//		languages.add(lang);
//	}
	
	public void addLanguage(Language lang){
	    languageRepository.save(lang);
	}
	
//	public Language getLanguage(int id) {
//		return languages.get(id);
//	}
	
	public Language getLanguage(long id) {
		return languageRepository.findOne(id);
	}
	
//	public void updateLanguage(int id, Language lang) {
//		languages.set(id, lang);
//	}
	
	public void updateLanguage(Language lang) {
		languageRepository.save(lang);
	}
	
//	public void deleteLanguage(int id) {
//		languages.remove(id);
//	}
	
	public void deleteLanguage(long id) {
		languageRepository.delete(id);
	}
	
}
