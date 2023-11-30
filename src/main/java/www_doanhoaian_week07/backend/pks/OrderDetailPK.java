package www_doanhoaian_week07.backend.pks;


import lombok.Getter;
import lombok.Setter;
import www_doanhoaian_week07.backend.models.Order;
import www_doanhoaian_week07.backend.models.Product;

import java.io.Serializable;

@Setter
@Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
