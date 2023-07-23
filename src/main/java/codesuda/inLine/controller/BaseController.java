package codesuda.inLine.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController implements ErrorController {

    @GetMapping("/")
    public String root() {
        return "index";     //jsp 의 기본 path 는 src/main/webapp 이다
                            // thymleaf 의존성 추가한 경우 index.html 은 맨 처음 static 폴더에서 찾고 그다음 thymeleaf 폴더에서 찾는다.
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }
}
