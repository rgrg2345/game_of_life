package GameOfLife;

public class Main {
	
	public static void main(String[] argv) throws InterruptedException{
		//LinkedList<environment>list = new LinkedList<environment>();
		
		//creat environment
		environment env =new environment(10); // �إߪ���M�ͦ�����     mapsize 30x30
		env.shownext();//�o�N�����Ҫ��p
		
		env.RcreatBiology(20);//�üƥͦ��ͪ�
		env.showmap();//��ܥͪ�����
		
		for(int i=0;i<100;i++){
			//Thread.sleep(500);
			System.out.print("\f");
			env.nextGeneration();//�ͦ��U�@�N
			env.showmap();//��ܥͪ�����
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