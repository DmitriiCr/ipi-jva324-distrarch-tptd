package com.ipi.jva324.stock;

import com.ipi.jva324.StockApplication;
import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.repository.ProduitEnStockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(StockApplication.class)
public class StockTest {

    @Autowired
    private ProduitEnStockRepository produitEnStockRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void TestProduitEnStock(){
        ProduitEnStock produitEnStock = new ProduitEnStock("Papier crepon","du papier", 5000L);
        produitEnStockRepository.save(produitEnStock);

        List<ProduitEnStock> resultat = produitEnStockRepository.findByNom("Papier crepon");

        assertEquals(resultat.get(0).getNom(),"Papier crepon");
    }
}
