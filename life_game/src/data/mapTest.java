package data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mapTest {
	map Map = new map(20,20);

	@Before
	public void setUp() throws Exception {
		Map.initMap();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitMap() {
	
		int number1 = 0 ;
		int number2 = 0 ;
		
		for(int i = 0 ;i<20;i++)
			for(int j = 0;j<20;j++)
			{
				if(Map.getMapcell(i, j) ==0)
					number1++;
				else
					number2++;
			}
		assertEquals(400,number1+number2);
	}
	
	@Test
	public void testgetMapcell() {
		//Map.initMap();
		int num =0;
	    boolean flag= false ;
		int[] t = {-1,0,1,18,19,20};
		for(int i = 0;i<6;i++)
			for(int j =0;j<6;j++)
			{
				flag = false;
				num = Map.getMapcell(t[i], t[j]);
				if(t[i]== -1||t[i]== 20||t[j] == -1||t[j]== 20)
				{
					assertEquals(-1,num);
				}
				else
				{
					if(num == 0||num == 1) flag = true;
					assertEquals(true,flag);
				}
			}
		num = Map.getMapcell(10, 10);
		if(num == 0||num == 1) flag = true;
		assertEquals(true,flag);
	
	}
}
