package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class PhoneController {

    private final AtomicLong counter = new AtomicLong();
    @CrossOrigin
    @RequestMapping("/phonenumber")
    public Phone phone(@RequestParam(value="number", defaultValue="0") String number) {
        return new Phone(number);
    }
}
