package com.stock.stockquotemanager.controllers;

import com.stock.stockquotemanager.domain.stock.RequestStockDto;
import com.stock.stockquotemanager.domain.stock.Stock;
import com.stock.stockquotemanager.domain.stock.StockRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @GetMapping
    public ResponseEntity getAllStocks() {
        var allStocks = stockRepository.findAllByActiveTrue();
        return ResponseEntity.ok(allStocks);
    }
    @PostMapping
    public ResponseEntity postStock(@RequestBody @Valid RequestStockDto data) {
        Stock newStock = new Stock(data);
        stockRepository.save(newStock);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity findStockById() {
        return null;
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateStock(@RequestBody @Valid RequestStockDto data) {
        Optional<Stock> stockOptional = stockRepository.findById(data.id());
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setId(data.id());
            stock.setQuotes(data.quotes());
            stock.setDescription(data.description());
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //exclusão lógica
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteStock(@PathVariable String id){
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setActive(false);
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
