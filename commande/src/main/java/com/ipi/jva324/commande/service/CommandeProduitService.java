package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;

import java.util.List;

     public interface CommandeProduitService {
     ProduitEnStock getProduit(long id);
     List<ProduitEnStock> getProduitsFromStock();
}
