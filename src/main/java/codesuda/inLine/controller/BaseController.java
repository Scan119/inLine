package codesuda.inLine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class BaseController {

    @GetMapping("/")
    public String root() {
        log.debug("debug level logging check : application 에서 'logging.level.기본 패키지이름 =debug' 설정");

        return "index";     //jsp 의 기본 path 는 src/main/webapp 이다
                            // thymleaf 의존성 추가한 경우 index.html 은 맨 처음 static 폴더에서 찾고 그다음 thymeleaf 폴더에서 찾는다.
    }
}
