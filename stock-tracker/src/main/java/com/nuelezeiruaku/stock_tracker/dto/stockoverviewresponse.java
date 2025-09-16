package com.nuelezeiruaku.stock_tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record stockoverviewresponse() {
    @JsonProperty("Symbol") String symbol,
    @JsonProperty("Name") String assetType,
    @JsonProperty("Description") String description,
    @JsonProperty("Sector") String sector,
    @JsonProperty("Industry") String industry,
    @JsonProperty("MarketCapitalization") String marketCap,
    @JsonProperty("PERatio") String peRatio,
    @JsonProperty("DividendYield") String dividendYield

} {}
