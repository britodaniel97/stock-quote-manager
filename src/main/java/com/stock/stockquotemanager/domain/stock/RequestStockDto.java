package com.stock.stockquotemanager.domain.stock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record RequestStockDto (
        @NotNull @NotBlank String id,
        @NotNull Double quotes,
        String description,

        Timestamp createdAt) {

}
