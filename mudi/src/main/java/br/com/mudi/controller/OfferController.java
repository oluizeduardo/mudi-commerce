package br.com.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mudi.dto.NewOfferRequest;
import br.com.mudi.model.Offer;
import br.com.mudi.repository.OfferRepository;

@Controller
@RequestMapping("offer")
public class OfferController {

	
	@Autowired
	private OfferRepository offerRepository;
	
	
	
	@GetMapping("/formNewOffer")
	public String newForm(NewOfferRequest request) {
		return "offer/formNewOffer";
	}
	
	
	@PostMapping("/newOffer")
	public String newOffer(@Valid NewOfferRequest newOfferRequest, BindingResult result) {
		
		if(result.hasErrors()) {
			return "offer/formNewOffer";
		}
		
		Offer offer = newOfferRequest.toOffer();
		offerRepository.save(offer);
		
		return "home";
	}
	
}
