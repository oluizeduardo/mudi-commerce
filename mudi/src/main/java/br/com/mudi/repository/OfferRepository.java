package br.com.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mudi.model.Offer;
import br.com.mudi.model.StatusOffer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	/**
	 * Select all the offers with the given status.
	 * @param status
	 * @return A List of Offers.
	 */
	List<Offer> findByStatus(StatusOffer status);

}
