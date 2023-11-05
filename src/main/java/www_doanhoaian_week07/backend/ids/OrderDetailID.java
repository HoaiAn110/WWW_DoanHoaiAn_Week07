package www_doanhoaian_week07.backend.ids;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailID implements Serializable {
    private Long order;
    private Long product;
}
