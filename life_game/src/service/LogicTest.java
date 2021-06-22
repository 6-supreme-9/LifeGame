package service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.map;
public class LogicTest {
	private  map Map;
	private Logic logic;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
/*	public void testCount() {

		
		logic = new Logic();
		logic.Start(20, 20);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				 logic.SetCell(i,j,1);
			}
		}
		logic.Count(20,20);
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				if((i>0&i<19)&&(j>0&j<19)) {
				assertEquals(8,logic.GetValue(i, i));
				}
				else if((i==0&&j==0)||(i==0&&j==19)||(i==19&&j==0)||(i==19&&j==19)) {
				//else if((i==0||i==19)&&(j==0||j==19)) {
					assertEquals(3,logic.GetValue(i, j));
				}
				else{
					assertEquals(5,logic.GetValue(i, j));
				}
			}
		}
		
	}*/
	
	public void testCount() {
		logic = new Logic();
		logic.Start(4, 4);
		
		logic.SetCell(0,0,1);		logic.SetCell(0,1,1);		logic.SetCell(0,2,1);		logic.SetCell(0,3,0);
		logic.SetCell(1,0,1);		logic.SetCell(1,1,1);		logic.SetCell(1,2,0);       logic.SetCell(1,3,1);
		logic.SetCell(2,0,0);		logic.SetCell(2,1,1);		logic.SetCell(2,2,1);       logic.SetCell(2,3,0);
		logic.SetCell(3,0,0);		logic.SetCell(3,1,0);		logic.SetCell(3,2,1);       logic.SetCell(3,3,0);

		logic.Count(4,4);
		assertEquals(3,logic.GetValue(0, 0));
		assertEquals(6,logic.GetValue(1, 1));
		assertEquals(4,logic.GetValue(2, 2));
		assertEquals(2,logic.GetValue(3, 3));

		assertEquals(1,logic.GetValue(3, 0));
		assertEquals(3,logic.GetValue(3, 1));
		assertEquals(2,logic.GetValue(3, 2));
		
		logic.Start(3, 3);
		logic.SetCell(0,0,1);		logic.SetCell(0,1,1);		logic.SetCell(0,2,1);	
		logic.SetCell(1,0,1);		logic.SetCell(1,1,1);		logic.SetCell(1,2,1);      
		logic.SetCell(2,0,1);		logic.SetCell(2,1,1);		logic.SetCell(2,2,1);
		
		logic.Count(3,3);

		assertEquals(3,logic.GetValue(0, 0));
		assertEquals(8,logic.GetValue(1, 1));
		assertEquals(5,logic.GetValue(0, 1));
		
		logic.SetCell(0,0,0);		logic.SetCell(0,1,0);		logic.SetCell(0,2,0);	
		logic.SetCell(1,0,0);		logic.SetCell(1,1,0);		logic.SetCell(1,2,0);      
		logic.SetCell(2,0,0);		logic.SetCell(2,1,0);		logic.SetCell(2,2,0);
		logic.Count(3,3);
		assertEquals(0,logic.GetValue(0, 0));
		assertEquals(0,logic.GetValue(1, 1));
		assertEquals(0,logic.GetValue(0, 1));
	}
	
	@Test
	 public void testGenerate()
	{
		logic = new Logic();
		logic.Start(4, 4);
		
		
		logic.SetCell(0,0,1);		logic.SetCell(0,1,1);		logic.SetCell(0,2,1);		logic.SetCell(0,3,0);
		logic.SetCell(1,0,1);		logic.SetCell(1,1,1);		logic.SetCell(1,2,0);       logic.SetCell(1,3,1);
		logic.SetCell(2,0,0);		logic.SetCell(2,1,1);		logic.SetCell(2,2,1);       logic.SetCell(2,3,0);
		logic.SetCell(3,0,0);		logic.SetCell(3,1,0);		logic.SetCell(3,2,1);       logic.SetCell(3,3,0);
		
		logic.Count(4, 4);
		logic.Generate(4,4);
		assertEquals(1,logic.GetCell(0, 0));//周围细胞数为3，但是本身是活细胞
		assertEquals(0,logic.GetCell(1, 1));
		assertEquals(0,logic.GetCell(2, 2));
		assertEquals(0,logic.GetCell(3, 3));//周围细胞数为2，但是本身是死细胞
		assertEquals(1,logic.GetCell(3, 1));//周围细胞数为3，但是本身是死细胞
		assertEquals(1,logic.GetCell(3, 2));//周围细胞数为2，但是本身是活细胞
		assertEquals(1,logic.GetCell(0, 0));
		
		
		logic.Start(3, 3);
		logic.SetCell(0,0,1);		logic.SetCell(0,1,1);		logic.SetCell(0,2,1);	
		logic.SetCell(1,0,1);		logic.SetCell(1,1,1);		logic.SetCell(1,2,1);      
		logic.SetCell(2,0,1);		logic.SetCell(2,1,1);		logic.SetCell(2,2,1);
		
		logic.Count(3,3);

		logic.Generate(3,3);
		assertEquals(1,logic.GetCell(0,0));
		assertEquals(0,logic.GetCell(1, 1));
		assertEquals(1,logic.GetCell(2, 2));
		assertEquals(0,logic.GetCell(0, 1));
	}
	
	
	
	/*	@Test
 public void testGenerate() {
		logic = new Logic();
		logic.Start(18, 18);
		for(int i=0;i<18;i++) {
			for(int j=0;j<18;j++) {
				if(i>=0&&i<9) {
					logic.SetCell(i,j,1); 
					logic.SetValue(i, j, i);
				}
				else {
					logic.SetCell(i,j,0); 
					logic.SetValue(i, j, i-9);
				}
			}
		}
		logic.Generate(18,18);
		for(int i=0;i<18;i++) {
			for(int j=0;j<18;j++) {
				if(i==2||i==3||i==12) {assertEquals(1,logic.GetCell(i, j));}
				else {assertEquals(0,logic.GetCell(i, j));}
			}
		}
	}*/

}
