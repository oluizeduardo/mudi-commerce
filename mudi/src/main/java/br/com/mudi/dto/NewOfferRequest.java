package br.com.mudi.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.mudi.model.Offer;
import br.com.mudi.model.Product;
import br.com.mudi.model.StatusOffer;
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
	@Digits(integer = 9, fraction = 2)
	private BigDecimal productPrice;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String productImageUrl;

	@Length(max = 500)
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
		order.setStatus(StatusOffer.ON_SALE);

		return order;
	}
}
