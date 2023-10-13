package org.sid.compteservice;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.enums.TypeCompte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Compte.class);
        return args -> {
            compteRepository.save(new Compte(null,98000,new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null,12000,new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null,898000,new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach(compte -> {
                System.out.println(compte.getType());
                System.out.println(compte.getSolde());
            });

        };
    }
}
