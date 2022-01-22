package br.com.mudi.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.mudi.model.Order;
import br.com.mudi.model.Product;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		
		Product newProduct = new Product();
		newProduct.setName("Smartphone Samsung Galaxy M12 64GB");
		newProduct.setUrlProduct("https://www.americanas.com.br/produto/3163815845?cor=AZUL");
		newProduct.setUrlImage("https://images-americanas.b2w.io/produtos/01/00/img/3163816/0/3163816071_2SZ.jpg");
		
		Order newOrder = new Order();
		newOrder.setProduct(newProduct);
		newOrder.setDescription("Gostaria desse modelo de preferência na cor cinza.");
		newOrder.setNegotiableValue(new BigDecimal(189));
		
		List<Order> orders = Arrays.asList(newOrder,newOrder,newOrder,newOrder);
		model.addAttribute("orders", orders);

		return "home";
	}
	
}
