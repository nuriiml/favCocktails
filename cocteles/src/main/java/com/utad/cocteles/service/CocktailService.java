package com.utad.cocteles.service;

import com.utad.cocteles.model.Cocktail;
import com.utad.cocteles.repository.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CocktailService {

    private final CocktailRepository cocktailRepository;

    @Autowired
    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }
    public List<Cocktail> getCocktails() {
        return cocktailRepository.findAll();
    }

    public Cocktail getCocktailById(Long id) {
        return cocktailRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cocktail not found with id: " + id));
    }

    public Cocktail save(Cocktail cocktail){
        return cocktailRepository.save(cocktail);
    }

    public Cocktail createCocktail(String name, double price) {
        Cocktail newCocktail = new Cocktail();
        newCocktail.setName(name);
        newCocktail.setPrice(price);
        return cocktailRepository.save(newCocktail);
    }
    public Cocktail updateCocktail(Long id, Cocktail newCocktailData) {
        Cocktail existingCocktail = getCocktailById(id);
        existingCocktail.setName(newCocktailData.getName());
        existingCocktail.setPrice(newCocktailData.getPrice());
        return cocktailRepository.save(existingCocktail);
    }

    public void deleteCocktail(Long id) {
        Cocktail cocktail = getCocktailById(id);
        cocktailRepository.delete(cocktail);
    }
}
