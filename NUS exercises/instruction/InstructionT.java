import java.util.*;

class Instruction {
	private static int N;
	private static int K;
	private static Queue<Integer> nums = new Queue<Integer>();
	private static Queue<Character> ops = new Queue<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();

		int num;
		char op;
		for(int i=0; i<N; i++) {
			num = sc.nextInt();
			sc.nextLine();
			op = sc.next().charAt(0);

			nums.offer(num);
			ops.offer(op);
		}
		System.out.println(tryInstruct(0));
	}

	private static int tryInstruct(int curr) {
		if(curr == K) {
			return curr;
		}
		else {
			int miniAns1 = tryInstruct(curr);

			int newCurr = performInstruct(curr, nums.poll(), ops.poll());
			int miniAns2 = tryInstruct(newCurr);

			int dist1 = Math.abs(K - miniAns1);
			int dist2 = Math.abs(K - miniAns2);

			if(dist1 < dist2) {
				return dist1;
			}
			else if(dist1 > dist2) {
				return dist2;
			}
			else {
				return dist1;
			}
		}
	}

	private static int performInstruct(int curr, int num, char op) {
		if(op == '+') {
			curr += num;
		}
		else if(op == '-') {
			curr -= num;
		}
		else if(op == '*') {
			curr *= num;
		}
		else if(op == '/') {
			curr /= num;
		}
		else {
			System.out.println("error");
		}
		return curr;
	}
}

class Queue<E> { 
	private LinkedList<E> list;
	public Queue() { 
		list = new LinkedList <E> (); 
	} 
	
	public boolean isEmpty() { 
		return list.isEmpty(); 
	} 
	
	public boolean offer(E o) {
		 list.addLast(o); 
		 return true;
	}

	public E peek() {
		  if (isEmpty()) return null;
		    return list.getFirst();
	}
	 
	 public E poll() {
		   E obj = peek();
		     if (!isEmpty()) list.removeFirst();
			   return obj;
	 }
}
