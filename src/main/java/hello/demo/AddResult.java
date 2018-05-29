package hello.demo;

public class AddResult {

    private final Integer one;
    private final Integer two;

    public AddResult(Integer numberOne, Integer numberTwo) {
        this.one = numberOne;
		this.two = numberTwo;
    }
	
    public Integer getOne() {
        return one;
    }

    public Integer getTwo() {
        return two;
    }
	
	
	public Integer getSum(){
		return (one+two);
	}
}