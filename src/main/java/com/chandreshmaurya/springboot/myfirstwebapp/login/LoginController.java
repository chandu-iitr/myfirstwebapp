package com.chandreshmaurya.springboot.myfirstwebapp.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private AuthenticateService authenticateService;

    ///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp

    @RequestMapping(value="login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login" ;
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if(authenticateService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }
        model.put("ErrorCredential", "Please Check Your Credential!");
        return "login";
    }
}
