package GameOfLife;

public class environment {

	private int mapSize;
	public Biology [][]map;
	private int generation;
	
	//init environment
	public environment(int size)
	{
		this.mapSize =size;
		this.generation=0;
		envInit();
	}
	
	//creat map
	private void envInit(){
		int size=mapSize ;
		map = new Biology[mapSize][mapSize];
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				map[i][j]=new Biology();//地圖上建立生物物件
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				setNeibor(i,j);//關聯所有物件
	}
	
	//creat random biology
	public void RcreatBiology(int num){
		int row,col;
		for(int i=0;i<num; i++)
			if(map[row=(int)(Math.random()*mapSize)][col=(int)(Math.random()*mapSize)].status==0)
				bornAndNeiborSet(row,col);
			else
				i--;
	}
	
	//next generation
	public void nextGeneration(){
		int size=mapSize;
		generation++;
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				map[i][j].nextGeneration();
		shownext();
		
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
					map[i][j].evolution();//生物演化至下一代
	}
	
	//顯示下一代有幾隻會死亡 幾隻會繁衍 幾隻不動作
	public void shownext(){
		int size=mapSize;
		//map[3][1].set();
		int born=0,die=0,idle=0;
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				if(map[i][j].nextStatus==0)
					idle++;
				else if(map[i][j].nextStatus==1){
					born++;
				}
				else
					die++;
		System.out.printf("\ndie:"+die+" born "+born+" idle "+idle+" \n");	
	}
	
	
	//setNeibor
	private void setNeibor(int row,int col){
		int pos[]={-1,0,1};
		for(int i=0;i<9;i++)
			if(row+pos[i/3]<0||col+pos[i%3]<0||row+pos[i/3]==mapSize || col+pos[i%3]==mapSize||i==4 )//out of range
				continue;
			else{
				map[row][col].neibor[i]=new Biology();
				map[row][col].setNeibor(map[row+pos[(int)(i/3)]][col+pos[i%3]],i);
			}
	}
	
	//*******************test function************************
	
	
	public void bornAndNeiborSet(int row,int col){
		map[row][col].born();
		setNeibor(row,col);
	}
	
	//Specific(x,y) born
	public void bornPos(int row,int col){
		bornAndNeiborSet(row,col);
	}
	//show the neibor
	public void showPosneibor(int row,int col){
		map[row][col].showNeibor();
	}
	
	//*******************test function************************
	
	//show whole map
	public void showmap(){
		int size=mapSize;
		
		System.out.println("第  "+generation+" 代");
		
		for(int i=0 ;i<size ;i++){
			for(int j=0;j<size ;j++){
				if(map[i][j]==null)	//defalut
					System.exit(1);
				System.out.print(" "+map[i][j].status2symbol());
				}
			System.out.println();
			}	
	System.out.printf("\n\n");	
	}
	
	
	
	
	
	
	
	
	
	
}


