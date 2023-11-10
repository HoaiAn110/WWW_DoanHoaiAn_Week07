package www_doanhoaian_week07.fontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import www_doanhoaian_week07.backend.Services.CustomerServices;
import www_doanhoaian_week07.backend.models.Customer;

import java.util.Optional;

@Controller
public class CustomerControllers {
    @Autowired
    private CustomerServices customerServices;


    @GetMapping("/cus_list")
    public String showCustomer(Model model){
        model.addAttribute("customer", customerServices.findAll());
        return "admin/customer/list";
    }



    @GetMapping("/addCustomer")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "admin/customer/add";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute Customer customer){
        customerServices.save(customer);
        return "redirect:cus_list";
    }



//
//    // Trong CustomerControllers.java
//    @GetMapping("/{id}")
//    public String updateCustomerForm(@PathVariable Long id, Model model) {
//        Optional<Customer> customer = customerServices.findById(id);
//        model.addAttribute("customer", customer);
//        return "admin/customer/update";
//    }

//    @GetMapping("/{id}")
//    public String updateCustomerForm(@PathVariable Long id, Model model) {
//        Optional<Customer> customerOptional = customerServices.findById(id);
//        if (customerOptional.isPresent()) {
//            Customer customer = customerOptional.get();
//            model.addAttribute("customer", customer);
//            return "admin/customer/update";
//        } else {
//            // Xử lý trường hợp không tìm thấy khách hàng
//            return "redirect:/cus_list"; // Hoặc hiển thị một thông báo lỗi
//        }
//    }
//
//
//    @PostMapping("/{id}")
//    public String updateCustomer(@ModelAttribute Customer customer) {
//        customerServices.save(customer);
//        return "redirect:/cus_list";
//    }
//




}
