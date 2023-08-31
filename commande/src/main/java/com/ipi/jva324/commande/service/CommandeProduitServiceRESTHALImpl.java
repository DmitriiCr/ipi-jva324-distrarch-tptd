package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Primary
@Component
public class CommandeProduitServiceRESTHALImpl implements CommandeProduitService {
    private final RestTemplate springDataRestTemplate;

    public CommandeProduitServiceRESTHALImpl(@Qualifier("springDataRestTemplate") RestTemplate springDataRestTemplate) {
        this.springDataRestTemplate = springDataRestTemplate;
    }

    @Value("${commande.apiserver.url:http://localhost:8080/}")
    private
    String url;

    @Override
    public ProduitEnStock getProduit(long id) {
        ProduitEnStock p = springDataRestTemplate.getForObject(url + "api/data-rest/produitEnStocks/" + id, ProduitEnStock.class);
        return p;
    }

    @Override
    public List<ProduitEnStock> getProduitsFromStock() {
        String getProduitsEndpoint = "api/data-rest/produitEnStocks"; // Change this endpoint as per your stock module

        // Make the HTTP GET request to the stock module's getProduits() endpoint
        ProduitEnStock[] produitsArray = springDataRestTemplate.getForObject(url + getProduitsEndpoint, ProduitEnStock[].class);

        if (produitsArray != null) {
            return Arrays.asList(produitsArray);
        } else {
            return Collections.emptyList();
        }
    }
}
