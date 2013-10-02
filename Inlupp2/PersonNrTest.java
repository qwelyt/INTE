package personnr;

import static org.junit.Assert.*;

import org.junit.Test;

/* giltiga personnr
800101-7808
800101-3880
901231-0356
901231-1156
850725-2537
020504-3557
020504-9760
*/
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
		PersonNr pnr = new PersonNr("800101-7808");
		PersonNr pnr1 = new PersonNr("020504-3557");
		PersonNr pnr2 = new PersonNr("901231-0356");
		PersonNr pnr3 = new PersonNr("800101-3880");
		PersonNr pnr4 = new PersonNr("020504+9760"); // Över 100
		PersonNr pnr5 = new PersonNr("850725-2537");
	}
	@Test(expected = IllegalArgumentException.class)
	public void test5(){
		PersonNr pnr = new PersonNr("010229-1234");
	}


}
