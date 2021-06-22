package data;
import java.util.Random;

public class map{
	private int[][] mapArray;
	private int rows;
	private int cols;
	private int[][] mapValue;
	
	
	public map(int rows,int cols) {
		this.rows=rows;
		this.cols=cols;

		
	}


	public int getMapcell(int x, int y) {
		if(x>=0&&x<rows&&y>=0&&y<cols)
			return mapArray[x][y];
		return -1;
	}

	public void setMapcell(int x,int y,int cell) {
		this.mapArray[x][y] = cell;
	}

	public void setMapvalue(int x ,int y,int value) {
		this.mapValue[x][y]=value;
	}
	
	public int getMapvalue(int x ,int y) {
		if(x>=0&&x<rows&&y>=0&&y<cols)
			return mapValue[x][y];
		else
			return -1;
	}
	
	public int getRow() {
		return rows;
	}

	public void setRow(int rows) {
		this.rows = rows;
	}

	public int getCol() {
		return cols;
	}

	public void setCol(int cols) {
		this.cols = cols;
	}
	
	
	public void initArray() {  
		mapArray = new int[rows][cols];
		mapValue = new int[rows][cols];
	}
	
	public void initMap()
	{
		initArray(); //分配空间
		Random r = new Random();
		for(int i = 0 ;i<rows;i++)
			for(int j =0;j<cols;j++)
			{
				int m = r.nextInt(2);
				if(m == 0)
				{
				setMapcell(i,j,0);//0表示死
				}
				else
				{
				setMapcell(i,j,1);//1表示生
				}
			}
	}
}