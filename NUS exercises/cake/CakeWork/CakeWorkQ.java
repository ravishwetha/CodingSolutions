/**
 * Name          : Ravi Shwetha
 * Matric number : A0146130W
 */

import java.util.*;
import java.text.*;

public class CakeWorkQ {
	private static int N;
	private static int K;

	public static void main(String[] args) {
		Queue<Block> queue = new Queue<Block>();
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		System.out.println(N +  " " + K);

		for(int i=0; i<N; i++) {
			String BlockLine = sc.nextLine();
			String[] BlockDesc = BlockLine.split("\\s+");

			String type = BlockDesc[0];

			String chocUnits = BlockDesc[1];
			int chocs = Integer.parseInt(chocUnits);

			Block block = new Block(type, chocs);

			queue.offer(block);
			printQ(queue);
		}
		System.out.println(getCurrentTimeStamp());
        System.out.println(sumMaxChocs(queue));
		System.out.println(getCurrentTimeStamp());
	}
	
	private static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	private static int sumMaxChocs(Queue<Block> queue) {
		Queue<Block> slider = new Queue<Block>();
		int sum = 0;
		int max = 0;

		int raisins = 0;
		while(!queue.isEmpty()) {
			printQ(queue);
			printQ(slider);
			do {
				slider.offer(queue.poll());
				if(queue.poll().getT().equals('R')) {
					raisins++;
				}
				sum+= queue.poll().getC();
				} while(raisins <= K);
				
			if(sum > max) {
				max = sum;
			}
			Block temp = slider.poll();
			if(temp.getT().equals('R')) {
				raisins--;
			}
		}
		return max;
	}

	private static void printQ(Queue<Block> queue) {
		if(queue.isEmpty()) {
			System.out.println("empty");
		}
		else {
			Queue<Block> pq = new Queue<Block>();
			pq = queue;
			
			while(!queue.isEmpty()) {
				System.out.print(queue.poll().getT() + queue.poll().getC() + " ");
			}
			System.out.println();
		}
	}
}

class Queue<E> {
	private LinkedList<E> list;

	public Queue() {
		list = new LinkedList<E>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean offer(E e) {
		list.addLast(e);
		return true;
	}

	public E peek() {
		if(isEmpty()) return null;
		return list.getFirst();
	}

	public E poll() {
		E obj = peek();
		if(!isEmpty())
			list.removeFirst();
		return obj;
	}
}

class Block {
	private String T;
	private int C;

	public Block(String T, int C) {
		this.T = T;
		this.C = C;
	}

	public String getT() {
		return this.T;
	}

	public int getC() {
		return this.C;
	}
}
