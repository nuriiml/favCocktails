package com.utad.cocteles.controller;

import com.utad.cocteles.model.Cocktail;
import com.utad.cocteles.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cocktails")
public class CocktailController {

    private final CocktailService cocktailService;

    @Autowired
    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping
    public ResponseEntity<List<Cocktail>> getAll() {
        List<Cocktail> list = cocktailService.getCocktails();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> getOne(@PathVariable Long id) {
        Cocktail cocktail = cocktailService.getCocktailById(id);
        return new ResponseEntity<>(cocktail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cocktail> createCocktail(@RequestBody Cocktail cocktail) {
        Cocktail createdCocktail = cocktailService.save(cocktail);
        return ResponseEntity.ok(createdCocktail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cocktail> updateCocktail(@PathVariable Long id, @RequestBody Cocktail cocktail) {
        Cocktail updatedCocktail = cocktailService.updateCocktail(id, cocktail);
        return new ResponseEntity<>(updatedCocktail, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCocktail(@PathVariable Long id) {
        cocktailService.deleteCocktail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
