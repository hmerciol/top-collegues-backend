package dev.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.webapp.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

}
