package GameOfLife;

public class Biology {

	//0. die 1. alive   (Default die)
	public int status=0;
	
	//0.idle 1. willBorn 2.willDie  (Default idle)
	private int nextStatus=0;
	
	//0. die 1. alive   (Default die)
	public int prevSatuts=0;
	
	//neibor
	public Biology []neibor= new Biology[9];
	
	//???
	//?@?
	//???
	public void setNeibor(Biology neibor, int pos){//call by reference
		this.neibor[pos]=neibor;
	}
	
	
	public void born(){
		this.prevSatuts=this.status;
		this.status=1;
	}
	public void die(){
		this.prevSatuts=this.status;
		this.status=0;
	}
	
	//find nextGeneration status
	public void nextGeneration(){
		if(this.status==0)//die == no biology
			return;
		this.nextStatus = 0;
		int cnt=0;
		for(int i=0;i<9;i++)
			if(i==4||this.neibor[i]==null)//out of range
				continue;
			else if(this.neibor[i].status==1)
				cnt++;
		
		if(cnt==1)
			findBornPos();
		else if(cnt>1)
			this.nextStatus = 2;
	}
	
	//find Multiply pos
	private void findBornPos(){
		int pos;
		for(int i=0;;i++){
			if(i>300){//maybe can't born
				int j;
				for(j=0;j<9;j++)
					if(i==4||this.neibor[j]==null||
							this.neibor[j].status==1||this.neibor[j].nextStatus!=0)
						continue;
					else
						break;
				pos=j;//if j>8 can't born
				break;
			}
			
			
			pos=(int)(Math.random()*9);
			if(pos==4||this.neibor[pos]==null||
					this.neibor[pos].status==1||this.neibor[pos].nextStatus!=0)
				continue;
			else
				break;
		}
		if(pos<9){ // find
			this.neibor[pos].nextStatus=1;	
		}
	}
	
	//do evolution
	public void evolution(){
		switch(this.nextStatus){
		case 2:
			die();
			break;
		case 1:
			born();	
			break;
		case 0://idle
		default:
			break;
		}
		this.nextStatus =0;
		
	}
	
	//return string for showmap 
	public String status2symbol(){
		return (this.status!=0)?"@":"-";
	}
	
	
	//*******************test function************************
	
	public void showNeibor(){
		for(int i=0;i<9;i++)
			if(i==4)
				System.out.printf(" "+this.status2symbol());
			else if(this.neibor[i]==null)
				System.out.printf(((i%3==0)?"\n":"")+" -");
			else
				System.out.printf(((i%3==0)?"\n":"")+" "+this.neibor[i].status2symbol());
	System.out.printf("\n\n");			
	}
	
	//*******************test function************************
}
