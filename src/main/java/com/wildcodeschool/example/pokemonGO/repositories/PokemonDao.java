package com.wildcodeschool.example.pokemonGO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.example.pokemonGO.entities.Pokemon;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Long> {
}
