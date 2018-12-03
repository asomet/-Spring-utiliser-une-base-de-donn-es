package com.wildcodeschool.example.pokemonGO.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wildcodeschool.example.pokemonGO.entities.Pokemon;
import com.wildcodeschool.example.pokemonGO.repositories.PokemonDao;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Pokemon");

    @Autowired
    private PokemonDao pokemonDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + pokemonDao.count());

        // Crée un nouvel utilisateur et l'enregistre dans la BDD
        Pokemon pokemon1 = new Pokemon("Pikachu", 2345);
        LOG.info("******************");
        LOG.info(pokemon1 + " has been created !");
        pokemonDao.save(pokemon1);
        LOG.info(pokemon1 + " has been saved !");

        // Crée un second utilisateur et l'enregistre dans la BDD
        Pokemon Pokemon2 = new Pokemon("Salamèche", 9875);
        LOG.info("******************");
        LOG.info(Pokemon2 + " has been created !");
        pokemonDao.save(Pokemon2);
        LOG.info(Pokemon2 + " has been saved !");

        // Lit les informations correspondant au second utilisateur
        Pokemon tempPokemon = pokemonDao.findById(2L).get(); /* On écrit "2L" car 
                                                       le type de l'id est Long */
        LOG.info("******************");
        LOG.info("Second pokemon's firstName is " + tempPokemon.getFirstName());
        LOG.info("Second pokemon's age is " + tempPokemon.getAge());

        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("******************");
        LOG.info("Pokemons in list are ");
        for(Pokemon myPokemon : pokemonDao.findAll()) {
            LOG.info(myPokemon.toString());
        };

        // Supprime le second utilisateur de la BDD
        pokemonDao.deleteById(2L); /* risque de provoquer une erreur si 
                                tu n'as pas vidé ta table avant de relancer 
                                ton application ! */

        /*     Liste les utilisateurs enregistrés dans la BDD
             (permet de vérifier que le second utilisateur
             a bien été supprimé de la BDD) */
        LOG.info("******************");
        LOG.info("Pokemons in list are ");
        for(Pokemon myPokemon : pokemonDao.findAll()) {
            LOG.info(myPokemon.toString());
        };
    }    
}
