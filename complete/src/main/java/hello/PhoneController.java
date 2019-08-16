package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/phonenumber")
    public Phone phone(@RequestParam(value="number", defaultValue="0") String name) {
        return new Phone(counter.incrementAndGet(),
                            name);
    }
}
