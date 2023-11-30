package www_doanhoaian_week07.fontend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/admin")
    public String showPageAdmin(){

            return "admin/admin-page";

    }

    @GetMapping("/shop")
    public String showPageShopping(){
            return "client/shopping-page";
    }
}
