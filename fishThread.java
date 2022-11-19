package week2ass;

import java.util.*;

class threadDemo{
	static List<Integer> l = new ArrayList<>(Arrays.asList(0,0,1,1,1,0,0,1,0,1
			,0,0,1,1,1,0,0,1,0,1)); //male=0, female=1
	synchronized void fun() {
		Random r=new Random();
		int x=21,y=21;
		x=r.nextInt(l.size());
		y=r.nextInt(l.size());
		while(x==y) y=r.nextInt(l.size());
		System.out.println("Random Positions generated are :"+x+","+y);
		synchronized(l) {
			if(l.get(x)==0 && l.get(y)==0) {
				l.remove(x);
				l.remove(y)
;
				System.out.println("Two male fishes met : "+l);
				System.out.println("And the size is : "+l.size());
			}
			else if(l.get(x)==1 && l.get(y)==1) {
				int d=new Random().nextBoolean()?x:y;
				l.remove(d);
				System.out.println("Two Female Fishes met : "+l);
				System.out.println("And the size is : "+l.size());
			}
			else if((l.get(x)==0 && l.get(y)==1)||(l.get(x)==1 && l.get(y)==0)) {
				int z=r.nextInt(2);
				int z1=r.nextInt(2);
				l.add(z);l.add(z1);
				System.out.println("A male and Female fish met : "+l);
				System.out.println("And the size is : "+l.size());
			}
		}
	}
}

class demo extends Thread{

	threadDemo t;
	demo(threadDemo t){
		this.t=t;
	}
	public void run() {
		t.fun();
	}
}

public class fishThread {
	public static void main(String args[]) {
		threadDemo t=new threadDemo();
		demo d=new demo(t);d.start();
		demo d1=new demo(t);d1.start();
		demo d2=new demo(t);d2.start();
		demo d3=new demo(t);d3.start();		
		demo d4=new demo(t);d4.start();

		
		
		
		
	}
}
