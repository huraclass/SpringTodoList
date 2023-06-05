package com.example.shopping.web.Login;

import com.example.shopping.domain.Member.Member;
import com.example.shopping.domain.login.LoginService;
import com.example.shopping.web.SessionConst;
import com.example.shopping.web.session.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "login/loginForm";
    }



    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm,
                          BindingResult bindingResult,
                          @RequestParam(defaultValue = "/")String redirectURL,
                          HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }
        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }

        request.getSession().setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:" + redirectURL;
    }


    @PostMapping("/logout")
    public String logoutV2(HttpServletRequest request,HttpServletResponse response) {
        sessionManager.expire(request);
        return "redirect:/";
    }

}
