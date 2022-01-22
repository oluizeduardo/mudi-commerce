package br.com.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private Integer id;
	private Product product;
	private BigDecimal negotiableValue;
	private LocalDate deliveryDate;
	private String description;
	
}
