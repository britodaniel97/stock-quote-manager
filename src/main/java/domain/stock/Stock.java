package domain.stock;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Table(name="stock")
@Entity(name="stock")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String stockName;
    private Double quote;
    private Date createdAt;

}


