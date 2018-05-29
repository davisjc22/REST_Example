package hello.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	@RequestMapping("/add")
    public AddResult add(@RequestParam(value="numberOne") Integer numberOne, @RequestParam(value="numberTwo")Integer numberTwo) {
        return new AddResult(numberOne, numberTwo);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@ResponseBody
	public AddResult add(@RequestBody AddResult input){
		return new AddResult(input.getOne(), input.getTwo());	//return type AddResult, using the integers from input
	}
}