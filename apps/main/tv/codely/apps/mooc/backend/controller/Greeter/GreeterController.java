package tv.codely.apps.mooc.backend.controller.Greeter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class GreeterController {
    @RequestMapping("/greeter")
    public HashMap<String, String> saludar(@RequestParam String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("response", "Hola " + name);
        return map;
    }
}
