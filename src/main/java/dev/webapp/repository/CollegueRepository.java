package dev.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.webapp.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, String> {

}
