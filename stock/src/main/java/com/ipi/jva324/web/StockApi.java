package com.ipi.jva324.web;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/data-rest")
public class StockApi {
    @Autowired
    private ProduitService produitService;

    @GetMapping(("/produitEnStocks"))
    public List<ProduitEnStock> getProduits() {
        return produitService.getProduits();
    }

    @GetMapping(("/produitEnStocks/{id}"))
    public ProduitEnStock getProduct(@PathVariable Long id) {
        return produitService.getProduit(id);
    }
}
