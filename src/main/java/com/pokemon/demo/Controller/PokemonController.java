package com.pokemon.demo.Controller;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("pokemons")
public class PokemonController {

    @GetMapping
    public NamedApiResourceList getPokemonList(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit) {
        PokeApi pokeApi = new PokeApiClient();
        return pokeApi.getPokemonList(offset, limit);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonDetail(@PathVariable int id) {
        PokeApi pokeApi = new PokeApiClient();
        return pokeApi.getPokemon(id);
    }
}
