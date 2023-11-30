package www_doanhoaian_week07.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www_doanhoaian_week07.backend.models.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart extends Product {
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return "Cart{" +
                "quantity=" + quantity +
                ", price=" + price +
                "} " + super.toString();
    }
}
