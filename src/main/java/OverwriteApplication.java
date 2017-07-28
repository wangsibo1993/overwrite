import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sibo.wang on 17/7/26.
 */
@RestController
@EnableAutoConfiguration
public class OverwriteApplication {

    @RequestMapping("/")
    public String home(){
        return "success";
    }

    public static void main(String[] args){
        SpringApplication.run(OverwriteApplication.class, args);
    }
}

