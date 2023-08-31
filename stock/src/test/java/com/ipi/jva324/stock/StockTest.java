package com.ipi.jva324.stock;

import com.ipi.jva324.Jva324Application;
import com.ipi.jva324.stock.model.ReceptionDeProduit;
import com.ipi.jva324.stock.repository.ReceptionDeProduitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(Jva324Application.class)
public class StockTest {

    @Autowired
    private static ReceptionDeProduitRepository receptionDeProduitRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    private void TestReceptionProduit(){
        LocalDateTime timestamp = LocalDateTime.now();
        ReceptionDeProduit reception = new ReceptionDeProduit(1L, "PROD123", 10L, timestamp);

        receptionDeProduitRepository.save(reception);

        List<ReceptionDeProduit> receptions = receptionDeProduitRepository.findAll();

        assertNotNull(receptions.get(0)); //si index 0 est null en contenu, alors rien n'a été inséré

    }
}
