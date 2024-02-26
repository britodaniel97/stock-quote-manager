package com.stock.stockquotemanager.domain.stock;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Table(name="stocks")
@Entity(name = "stocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {

    @Id
    private String id;
    private Double quotes;
    private String description;

    //@ColumnDefault(value = "now()")
    private Timestamp createdAt;

    private Boolean active;

    public Stock(RequestStockDto requestStockDto) {
        this.id = requestStockDto.id();
        this.quotes = requestStockDto.quotes();
        this.description = requestStockDto.description();
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.active = true;
    }
}

