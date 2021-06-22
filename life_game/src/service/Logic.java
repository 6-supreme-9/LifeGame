 package service;
 import data.map;
 public class Logic
 {
	 public static int[] flag= {-1,0,1};

	  private map Map;
	  
	public Logic(){}
	

	 public int GetCell(int x,int y)
	 {
		return Map.getMapcell(x, y);
	 }
	  
	 
	 public void SetCell(int row,int col,int value) {  //用于设置某行某列的细胞状态为1
		 Map.setMapcell(row,col,value);
		}
		 
	 public int GetValue(int x,int y)
	 {
		return Map.getMapvalue(x, y);
	 }
	  
	 
	 public void SetValue(int row,int col,int value) { 
		 Map.setMapvalue(row,col,value);
		}
		 
	 
	 public void Start(int rows,int cols)   //开始分配地图空间，并且初始地图状态
	 {
		 Map = new map(rows,cols);
		 Map.initMap();
	 }
	 
	 public  void Release()
	 {
		 Map = null;
		 System.gc();
	 }
	 
	 
	/* public void upDate(int rows, int cols) {
		 this.setRowCol(rows, cols);
		 Map.initMap(); //重新生成新的地图
	}*/
	 /*public void setRowCol(int rows,int cols) {
	 Map.setRow(rows);
	 Map.setCol(cols);
	}*/
 
	 
	 
	 
 public void Count(int rows,int cols)
	 { int count ;
		 for(int i=0;i<rows;i++)
			 for(int j =0;j<cols;j++)
			 { 
				 count = 0;
				for(int m=0;m<3;m++)
					for(int n =0 ;n<3;n++)
					{
						//if(m==1&&n==1)
						//continue;
				//else
						if(Map.getMapcell(i+flag[m], j+flag[n]) == 1)
						{
							count ++;
						}
					}
				if(Map.getMapcell(i, j)==1)  count--;
				Map.setMapvalue(i, j, count);
			 }
	 }
 
	/*public void Count(int rows,int cols)
	 { 
		 for(int i=1;i<rows-1;i++)
			 for(int j =1;j<cols-1;j++)
			 { 
				Map.setMapvalue(i, j, Map.getMapcell(i-1,j-1)+Map.getMapcell(i-1,j)+Map.getMapcell(i-1,j+1)
									 +Map.getMapcell(i,j-1)       +    			    Map.getMapcell(i,j+1)
									 +Map.getMapcell(i+1,j-1)+Map.getMapcell(i+1,j)+Map.getMapcell(i+1,j+1));
			 }
			 
			 
		for(int j = 1;j<cols-1;j++) 
		{
		 Map.setMapvalue(0, j, 		  Map.getMapcell(0,j-1)       +    			    Map.getMapcell(0,j+1)
									 +Map.getMapcell(1,j-1)+Map.getMapcell(1,j)+Map.getMapcell(1,j+1));
									 
		 Map.setMapvalue(rows-1, j, Map.getMapcell(rows-1,j-1)+Map.getMapcell(rows-1,j)+Map.getMapcell(rows-1,j+1)
									 +Map.getMapcell(rows-1,j-1)       +    		    Map.getMapcell(rows-1,j+1));
		}
		
	for(int i = 1;i<rows-1;i++) 
		{
		 Map.setMapvalue(i, 0,       Map.getMapcell(i-1,0)+Map.getMapcell(i-1,1)
									      +    	 Map.getMapcell(i,1)	  +
									Map.getMapcell(i+1,0)+Map.getMapcell(i+1,1));
									 
		 Map.setMapvalue(i, cols-1, Map.getMapcell(i-1,rows-2)+Map.getMapcell(i-1,rows-1)
									  +	 	 Map.getMapcell(i,rows-2)       +    			   
									Map.getMapcell(i+1,rows-2)+Map.getMapcell(i+1,rows-1));
		}
	
	Map.setMapvalue(0	  , 0	  , Map.getMapcell(0,1)+ Map.getMapcell(1,0)+Map.getMapcell(1,1));
	Map.setMapvalue(0     , cols-1, Map.getMapcell(0,cols-2)+ Map.getMapcell(1,cols-2)+Map.getMapcell(1,cols-1));
	Map.setMapvalue(rows-1, 0     , Map.getMapcell(rows-2,0)+ Map.getMapcell(rows-2,1)+Map.getMapcell(rows-1,1));
	Map.setMapvalue(rows-1, cols-1, Map.getMapcell(rows-2,cols-2)+ Map.getMapcell(rows-2,cols-1)+Map.getMapcell(rows-1,cols-2));
			 
}*/
	

	 
	 
	 public void Generate(int rows,int cols)
	 {
		 for(int i=0;i<rows;i++)
			 for(int j =0;j<cols;j++)
			 { 
				 if(Map.getMapvalue(i,j) == 3)
					 Map.setMapcell(i,j,1);
				 else if(Map.getMapvalue(i, j)==2&&Map.getMapcell(i, j)==1)
					 Map.setMapcell(i,j,1);
				 else
					 Map.setMapcell(i,j,0);
			 }
	 }
	 
	
 }