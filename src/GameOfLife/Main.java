package GameOfLife;

public class Main {
	
	public static void main(String[] argv) throws InterruptedException{
		//LinkedList<environment>list = new LinkedList<environment>();
		
		//creat environment
		environment env =new environment(30); // �إߪ���M�ͦ�����     mapsize 30x30
		
		env.RcreatBiology(450);//�üƥͦ��ͪ�
		env.showmap();//��ܥͪ�����
		
		for(int i=0;i<40;i++){
			Thread.sleep(500);
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