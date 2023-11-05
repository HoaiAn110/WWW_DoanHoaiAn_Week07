package www_doanhoaian_week07.backend.ids;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceID implements Serializable {
    private Long product;
    private LocalDate price_date_time;
}
