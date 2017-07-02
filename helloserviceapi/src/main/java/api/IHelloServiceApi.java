package api;

import bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tangzhilong on 17/7/1.
 */
public interface IHelloServiceApi {
    @RequestMapping("/")
    String hello();
    @RequestMapping("/sayHelloTo")
    String sayHelloTo(@RequestParam("uname") String uname);
    @RequestMapping("/getInfo")
    User getInfo(@RequestParam("uid") String uid);
    @RequestMapping("/user")
    String getInfo(@RequestParam("user") User user);
}
