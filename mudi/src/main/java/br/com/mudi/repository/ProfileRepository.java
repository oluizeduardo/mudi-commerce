package br.com.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mudi.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
