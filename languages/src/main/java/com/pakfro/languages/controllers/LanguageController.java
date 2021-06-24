package com.pakfro.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pakfro.languages.models.Language;
import com.pakfro.languages.services.LanguageService;

@Controller
public class LanguageController {
	
	private final LanguageService langServ;
	
	public LanguageController (LanguageService langServ) {
		this.langServ = langServ;
	}
	
	// Show the index route, which has all the languages and the form.
	
	@RequestMapping ("/languages")
	public String index(Model model, @ModelAttribute("languages") Language language) {
		this.langServ.allLangauges();
		
		model.addAttribute("allLanguages", this.langServ.allLangauges());
		
		return "index.jsp";
	}
	
	// Create a POST request to create new language
	
	@PostMapping ("/languages")
	public String newLanguage (@Valid @ModelAttribute("languages") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allLanguages", this.langServ.allLangauges() );
            return "index.jsp";
        } else {
            this.langServ.createLanguage(language);
            return "redirect:/languages";
        }
	}
	
	// Edit / update the language.
	
	@RequestMapping("/languages/edit/{langId}")
	public String editLang(@PathVariable("langId") Long id, Model model) {
		
		Language lang = this.langServ.getLang(id);
        model.addAttribute("language", lang);
        
		return "edit.jsp";
	}
	
	
	@RequestMapping(value = "/languages/{id}/update", method= RequestMethod.POST)
	public String updateLangy(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			this.langServ.updateLang(language);
			return "redirect:/languages";
		}
	}
	
	
	// Show one language on a page.
	@RequestMapping("/languages/{id}")
	public String showLang(@Valid Language language, BindingResult result, @PathVariable("id")Long id, Model model) {
		
		Language lang = this.langServ.getLang(id);
		model.addAttribute("langy", lang);
		
		return "show.jsp";
	}
	
	// Delete a language
	@RequestMapping("/languages/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		this.langServ.deleteLang(id);
		return "redirect:/languages";
	}
}
