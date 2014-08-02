package GameOfLife;

public class Main {
	
	public static void main(String[] argv) throws InterruptedException{
		//LinkedList<environment>list = new LinkedList<environment>();
		
		//creat environment
		environment env =new environment(10); // 建立物件和生成環境     mapsize 30x30
		env.shownext();//這代的環境狀況
		
		env.RcreatBiology(20);//亂數生成生物
		env.showmap();//顯示生物分布
		
		for(int i=0;i<100;i++){
			//Thread.sleep(500);
			System.out.print("\f");
			env.nextGeneration();//生成下一代
			env.showmap();//顯示生物分布
		}
		
		
		
	}
	
}


/*******************test code************************

env.bornPos(7,1);

env.showmap();

env.showPosneibor(7,0);

env.bornPos(7,2);

env.showmap();

env.showPosneibor(7,0);

env.bornPos(6,1);

env.showmap();

env.showPosneibor(7,0);		
*******************test code************************/