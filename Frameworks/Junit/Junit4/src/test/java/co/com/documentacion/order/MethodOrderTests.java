package co.com.documentacion.order;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MethodOrderTests {

	@Test
	public void testC() {
		System.out.println("third");
	}			
	
	@Test
	public void testA() {
		System.out.println("first");
	}
	
	@Test
	public void testB() {
		System.out.println("second");
	}

}
