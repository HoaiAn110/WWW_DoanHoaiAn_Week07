package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.ids.OrderDetailID;
import www_doanhoaian_week07.backend.models.OrderDetail;
import www_doanhoaian_week07.backend.repositories.OrderDetailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServices {
    @Autowired
    private OrderDetailRepository orderDetailRepository;


    public List<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }

    public Optional<OrderDetail> findById(OrderDetailID id){
        return orderDetailRepository.findById(id);
    }


    public void saveOrderDetail(OrderDetail orderDetail){
         orderDetailRepository.save(orderDetail);
    }




}
