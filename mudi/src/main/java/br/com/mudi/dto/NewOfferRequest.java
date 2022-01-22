package br.com.mudi.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.mudi.model.Offer;
import br.com.mudi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewOfferRequest {

	@NotBlank
	private String productName;
	
	@NotNull
	@DecimalMin(value = "0.01", inclusive = false)
    @Digits(integer=3, fraction=2)
	private BigDecimal productPrice;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String productImageUrl;

	private String description;
	
	
	/**
	 * It converts a {@link NewOfferRequest} to {@link Offer}.
	 * @return and {@link Offer} object.
	 */
	public Offer toOffer() {
		
		Product product = new Product();
		product.setName(productName);
		product.setPrice(productPrice);
		product.setUrlProduct(productUrl);
		product.setUrlImage(productImageUrl);
		product.setDescription(description);
		
		Offer order = new Offer();
		order.setProduct(product);

		return order;
	}
}
