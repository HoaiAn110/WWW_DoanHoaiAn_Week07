package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import www_doanhoaian_week07.backend.models.Order;
import www_doanhoaian_week07.backend.repositories.OrderReposirory;

import java.util.List;

@Service
public class OrderServices {
    @Autowired
    private OrderReposirory orderReposirory;


   public List<Order> findAll(){
       return orderReposirory.findAll();
   }

    public Order save(Order order) {
        return orderReposirory.save(order);
    }
    public Order findById(Long id) {
        return orderReposirory.findById(id).orElse(null);
    }





}
