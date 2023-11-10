package www_doanhoaian_week07.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import www_doanhoaian_week07.backend.Services.*;
import www_doanhoaian_week07.backend.models.*;

import java.util.Optional;

@Controller
public class OrderControllers {
    @Autowired
    private OrderServices orderServices;

    @Autowired
    private OrderDetailServices orderDetailServices;

    @Autowired
    private EmployeeControllers employeeServices;

    @Autowired
    private CustomerServices customerServices;


    @GetMapping("/list_order")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderServices.findAll());
        return "admin/order/list";
    }


//    @GetMapping("/add_order")
//    public String addorder(){
//
//        return "admin/order/add";
//    }


//    @PostMapping("/add_order")
//    public String addOrder(@RequestParam("orderDate") String orderDateStr, // Receive as String
//                           @RequestParam("quantity") int quantity,
//                           @RequestParam("price") double price,
//                           @RequestParam("note") String note,
//                           @RequestParam("product_id") Long productId) {
//
//        // Parse orderDate using DateTimeFormatter
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime orderDate = LocalDate.parse(orderDateStr, formatter).atStartOfDay();
//
//
//
//        if (productOptional.isPresent()) {
//            Product product = productOptional.get();
//
//            Order newOrder = new Order();
//            newOrder.setOrderDate(orderDate);
//
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setQuantity(quantity);
//            orderDetail.setPrice(price);
//            orderDetail.setNote(note);
//
//            newOrder.(product);
//            newOrder.addOrderDetail(orderDetail);
//
//            orderServices.save(newOrder);
//        }
//
//        return "redirect:/list_order";
//    }


    @GetMapping("/add_order")
    public String creatrOrder(Model model) {
        model.addAttribute("order", new Order());
        return "admin/order/add";
    }


    @PostMapping("/add_order")
    public String saveOrder(@ModelAttribute Order order, @RequestParam("id") long cust_id, @RequestParam("id") long emp_id) {
        Optional<Customer> customerOptional = customerServices.findById(cust_id);
        Optional<Employee> employeeOptional = employeeServices.findById(emp_id);

        if (customerOptional.isPresent() && employeeOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Employee employee = employeeOptional.get();

            customer = order.getCustomer();
            employee = order.getEmployee();

            customerServices.save(customer);
            employeeServices.(employee);

            orderServices.save(order);

        }
        return "redirect:/list_order";
    }

}


