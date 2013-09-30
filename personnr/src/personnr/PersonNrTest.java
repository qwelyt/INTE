package personnr;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonNrTest {

	@Test(expected = IllegalArgumentException.class)
	public void InputTest(){
		PersonNr pnr = new PersonNr("0010a-1234");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test2(){
		PersonNr pnr = new PersonNr("");
	}
	@Test(expected = IllegalArgumentException.class)
	public void test3(){
		PersonNr pnr = new PersonNr(null);
	}
	@Test
	public void test4(){
		PersonNr pnr = new PersonNr("000229-1234");
		PersonNr pnr1 = new PersonNr("000131-1234");
		PersonNr pnr2 = new PersonNr("001231-1234");
		PersonNr pnr3 = new PersonNr("000301-1234");
		PersonNr pnr4 = new PersonNr("040202+1234"); // Över 100
		PersonNr pnr5 = new PersonNr("991231-9992");
	}
	@Test(expected = IllegalArgumentException.class)
	public void test5(){
		PersonNr pnr = new PersonNr("010229-1234");
	}


}
