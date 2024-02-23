package controllers;

import domain.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @GetMapping
    public ResponseEntity getAllStocks() {
        var allProducts = stockRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }
}
