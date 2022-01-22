package br.com.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mudi.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {


}
