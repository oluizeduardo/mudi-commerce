package br.com.mudi.controller;

import java.util.List;

import javax.websocket.OnError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mudi.model.Offer;
import br.com.mudi.model.StatusOffer;
import br.com.mudi.repository.OfferRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private OfferRepository offerRepository;
	
	
	@GetMapping
	public String home(Model model) {
		
		List<Offer> offers = offerRepository.findAll();
		
		model.addAttribute("offers", offers);
		return "home";
	}
	
	@GetMapping("offers/{status}")
	public String byStatus(@PathVariable("status") String status, Model model) {
		
		List<Offer> offers = offerRepository.findByStatus(StatusOffer.valueOf(status.toUpperCase()));
		
		model.addAttribute("offers", offers);		
		model.addAttribute("status", status);
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
