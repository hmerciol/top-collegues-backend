package dev.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.webapp.entity.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

}
