package br.com.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mudi.model.Offer;
import br.com.mudi.repository.OfferRepository;

@Controller
public class HomeController {

	@Autowired
	private OfferRepository offerRepository;
	
	
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Offer> offers = offerRepository.findAll();
		
		model.addAttribute("offers", offers);
		return "home";
	}
	
}
