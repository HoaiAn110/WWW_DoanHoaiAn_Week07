package www_doanhoaian_week07.fontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import www_doanhoaian_week07.backend.Services.EmployeeServices;

@Controller
public class EmployeeControllers {
    private EmployeeServices employeeServices;


    @GetMapping("/list_emp")
    public String showAllEmployee(Model model){
        model.addAttribute("employees",employeeServices.findAll());
        return "admin/employee/list";
    }
}
