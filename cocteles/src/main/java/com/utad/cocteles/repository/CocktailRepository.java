package com.utad.cocteles.repository;

import com.utad.cocteles.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailRepository extends JpaRepository<Cocktail, Long> {
}
