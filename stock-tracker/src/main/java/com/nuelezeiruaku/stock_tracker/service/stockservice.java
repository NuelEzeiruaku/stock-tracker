package com.nuelezeiruaku.stock_tracker.service;

import org.springframework.streotype.Service;
import com.nuelezeiruaku.stock_tracker.client.StockClient;
import com.nuelezeiruaku.stock_tracker.dto.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annonation.GetMapping;
import org.springframework.web.bind.annonation.PathVariable;
import org.springframework.web.bind.annonation.RequestMapping;
import org.springframework.web.bind.annonation.RestController;

@Service
public class StockService {

    private StockClient stockClient;

    public StockService(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockResponse getStockForSymbol(final String stockSymbol) {
        final AlphaVantageResponse response = stockClient.getStockQuote(stockSymbol);

        return StockResponse.builder()
                .symbol(response.globalQuote().symbol())
                .price(Double.parseDouble(response.globalQuote().price()))
                .lastUpdated(response.globalQuote().lastTradingDay())
                .build()
    }

    public StockOverviewResponse getStockOverviewForSymbol(final String symbol) {
        return stockClient.getStockOverview(symbol);
    }
}

@Ser