/***********************************************************************
	FileName	[Biology.java]
	PackageName	[GameOfLife]
	JavaProjectName	[GameOfLife]
	synopsis	[Biology object and methods]
	Author		[Cai Meng Ting]
	Copyright	[ Copyleft(c) 2014 MITLAB, GIEE, NTUST, Taiwan ]
/***********************************************************************/
package GameOfLife;

public class Biology {

	//0. die 1. alive   (Default die)
	private int status=0;
	
	//0.idle 1. willBorn 2.willDie  (Default idle)
	private int nextStatus=0;
	
	//0. die 1. alive   (Default die)
	private int prevSatuts=0;
	
	//neibor
	public Biology []neibor= new Biology[9];  //neibor[4]always be null because it represent itself
	
	//???
	//?@?
	//???  '?'is neibor
	public void setNeibor(Biology neibor, int pos){//call by reference
		this.neibor[pos]=neibor;
	}
	
	
	public void born(){
		prevSatuts=status;
		status=1;
	}
	public void die(){
		prevSatuts=status;
		status=0;
	}
	
	//0:status 1:nextstatus 2:prevstatus
	public int getStatus(int type){
		return (type==2)?prevSatuts:(type==1)?nextStatus:status;
	}
	
	//find nextGeneration status
	public void nextGeneration(){
		if(status==0)//die == no biology
			return;
		int cnt=0;
		for(int i=0;i<9;i++)
			if(i==4||neibor[i]==null)//out of range
				continue;
			else if(neibor[i].status==1)
				cnt++;
		
		if(cnt==1){
			findBornPos();
			nextStatus = 0;
		}
		else if(cnt>2)
			nextStatus = 2;
		else
			nextStatus = 0;
	}

	//find Multiply pos
	private void findBornPos(){
		int pos;
		for(int i=0;;i++){
			if(i>300){//another way to find if random couldn't find
				int j;
				for(j=0;j<9;j++)
					if(i==4||neibor[j]==null||
							neibor[j].status==1||neibor[j].nextStatus!=0)
						continue;
					else
						break;
				pos=j;//if j>8 can't born
				break;
			}
			
			
			pos=(int)(Math.random()*9);
			if(pos==4||neibor[pos]==null||
					neibor[pos].status==1||neibor[pos].nextStatus!=0)
				continue;
			else
				break;
		}
		if(pos<9){ // find
			neibor[pos].nextStatus=1;
		}
	}
	
	//do evolution
	public void evolution(){
		switch(nextStatus){
		case 1:
			born();
			break;
		case 2:
			die();
			break;
		case 0://idle
		default:
			break;
		}
		nextStatus =0;
		
	}
	
	//return string for showmap 
	public String status2symbol(){
		return (status!=0)?"@":"-";
	}
	
	
	//*******************test function************************
	
	public void showNeibor(){
		for(int i=0;i<9;i++)
			if(i==4)
				System.out.printf(" "+status2symbol());
			else if(neibor[i]==null)
				System.out.printf(((i%3==0)?"\n":"")+" -");
			else
				System.out.printf(((i%3==0)?"\n":"")+" "+neibor[i].status2symbol());
	System.out.printf("\n\n");			
	}
	
	//*******************test function************************
}
