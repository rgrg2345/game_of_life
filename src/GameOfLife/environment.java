/***********************************************************************
	FileName	[environment.java]
	PackageName	[GameOfLife]
	JavaProjectName	[GameOfLife]
	synopsis	[environment object and methods]
	Author		[Cai Meng Ting]
	Copyright	[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
/***********************************************************************/
package GameOfLife;

public class environment {

	private int mapSize;
	public Biology [][]map;
	private int generation=0;
	
	//init environment
	public environment(int size)
	{
		this.mapSize =size;
		envInit();
	}
	
	//creat map
	private void envInit(){
		int size=mapSize ;
		map = new Biology[mapSize][mapSize];
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				map[i][j]=new Biology();//�a�ϤW�إߥͪ�����
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				setNeibor(i,j);//���p�Ҧ�����
	}
	
	//creat random biology
	public void RcreatBiology(int num){
		int row,col;
		if(num>mapSize*mapSize||num<0)//Error
			return;
		for(int i=0;i<num; i++)
			if(map[row=(int)(Math.random()*mapSize)][col=(int)(Math.random()*mapSize)].getStatus(0)==0)
				map[row][col].born();
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
					map[i][j].evolution();//�ͪ��t�ƦܤU�@�N
	}
	
	//��ܤU�@�N���X���|���` �X���|�c�l �X�����ʧ@
	public void shownext(){
		int size=mapSize;
		int born=0,die=0,idle=0;
		for(int i=0 ;i<size ;i++)
			for(int j=0;j<size ;j++)
				if(map[i][j].getStatus(1)==0)
					idle++;
				else if(map[i][j].getStatus(1)==1){
					born++;
				}
				else
					die++;
		System.out.printf("\ndie:"+die+" born "+born+" idle "+idle+" \n");	
	}
	

	//���p�ۨ��P�򪫥�
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
	
	
	//show whole map
	public void showmap(){
		int size=mapSize;
		
		System.out.println("��  "+generation+" �N");
		
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


}


