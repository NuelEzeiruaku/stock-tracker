package com.nuelezeiruaku.stock_tracker.controller;

import org.springframework.beans.factory.annonation.Autowired;
import org.springframework.web.bind.annonation.GetMapping;
import org.springframework.web.bind.annonation.PathVariable;
import org.springframework.web.bind.annonation.RequestMapping;
import org.springframework.web.bind.annonation.RestController;
import com.nuelezeiruaku.stock_tracker.service.StockService;
import com.nuelezeiruaku.stock_tracker.dto.StockResponse;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(final StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{stockSymbol}")
    // AAPL, SHOP, NVDA, AMZN
    public StockResponse getStock(@PathVariable String stockSymbol) {
        return stockService.getStockForSymbol(stockSymbol.toUpperCase());
    }

    @GetMapping("/{stockSymbol}/overview")
    pubblic StockOverviewResponse getStockOverview(@PathVariable String stockSymbol) {
        return stockService.getStockOverviewForSymbol(stockSymbol.toUpperCase());
    }
}