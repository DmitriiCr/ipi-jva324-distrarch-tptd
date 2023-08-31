package com.ipi.jva324.commande.web;

import com.ipi.jva324.commande.service.CommandeProduitService;
import com.ipi.jva324.stock.model.ProduitEnStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/data-rest")
public class CommandeController {
    @Autowired
    private CommandeProduitService commandeProduitService;

    @GetMapping("/produitEnStocks")
    public ResponseEntity<CollectionModel<ProduitEnStock>> getProductsFromStock() {
        List<ProduitEnStock> produits = commandeProduitService.getProduitsFromStock();
        produits.forEach(produit -> produit.add(linkTo(methodOn(CommandeController.class).getProductsFromStock()).withSelfRel()));

        CollectionModel<ProduitEnStock> collectionModel = CollectionModel.of(produits);
        return ResponseEntity.ok(collectionModel);
    }
}
