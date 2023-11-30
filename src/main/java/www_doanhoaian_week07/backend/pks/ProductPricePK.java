package www_doanhoaian_week07.backend.pks;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ProductPricePK implements Serializable {
    private long product;
    private LocalDateTime priceDateTime;


}
