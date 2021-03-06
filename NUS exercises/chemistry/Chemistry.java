/**
* Name          : Ravi Shwetha
* Matric number : A0146130W
*/

import java.util.*;

public class Chemistry {
	private static int N;
	private static ArrayList<Atom> AtomDirec;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		AtomDirec = new ArrayList<Atom>();
		
		for(int i=0; i<N; i++) {
			String atomLine = sc.nextLine();
			String[] Atoms = atomLine.split("\\s+");
			Atom atom = new Atom(Atoms[0].charAt(0), Integer.parseInt(Atoms[1]));
			AtomDirec.add(atom);
		}
		
		String moleculeS = sc.nextLine();
		ArrayList<Character> molecule = new ArrayList<Character>();
		for(Character c : moleculeS.toCharArray()) {
			molecule.add(c);
		}
		System.out.println(stackFormula(toPostfix(toInfix(molecule))));
	}

	//add operator symbols to molecular expression
	private static ArrayList<Character> toInfix(ArrayList<Character> molecule) {
		ArrayList<Character> infix = molecule;
		
		for(int i=0; i<infix.size()-1; i++) {
			char current = infix.get(i);
		    char next = infix.get(i+1);
		    if(current >= 'A' && current <= 'Z' && next >= '0' && next <= '9') 
				infix.add(i+1, '*');
			else if(current >= 'A' && current <= 'Z' && next != ')')
				infix.add(i+1, '+');
			else if((current >= '0' && current <= '9' && next != ')') || (current == ')' && next == '('))
				infix.add(i+1, '+');
			else if(current == ')' && next >= '0' && next <= '9')
			    infix.add(i+1, '*');
			else if(current == ')' && next >= 'A' && next <= 'Z')
			    infix.add(i+1, '+');
		}
		return infix;
	}
	
	private static ArrayList<Character> toPostfix(ArrayList<Character> infix) {
		Stack<Character> postStack = new Stack<Character>();
		ArrayList<Character> postfix = new ArrayList<Character>();
		
		for(int i=0; i<infix.size(); i++) {
			char curr = infix.get(i);
			if(curr == '+') {
				while(!postStack.empty() && postStack.peek() == '*') {
					postfix.add(postStack.pop());
				}
				postStack.push(curr);
			}
			else if(curr == '*')
				postStack.push(curr);
			else if(curr == ')') {
				while(!postStack.empty() && postStack.peek() != '(') {
					postfix.add(postStack.pop());
				}
				postStack.pop();
			}
			else if(curr == '(')
				postStack.push(curr);
			else if((curr >= 'A' && curr <= 'Z') || (curr >= '0' && curr <= '9'))
				postfix.add(curr);
		}
		while(!postStack.empty())
			postfix.add(postStack.pop());

		return reverseArrList(postfix);
	}
	
	private static int stackFormula(ArrayList<Character> postfix) {
		//formula was entirely composed of brackets
		if(postfix.isEmpty()) {
			return 0;
		}
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> store = new Stack<Integer>(); //stores the integer results of each of math operation, it's elements converge into 1 value: the answer
		stack.setArrList(postfix); //stack contains postfix expression in correct order.
		
		//initializes store by storing all letters and numbers from stack as integers in it
		while(stack.getSize() >= 1) {
			while(stack.getSize() != 0 && stack.peek() != '*' && stack.peek() != '+') {
				char LorN = stack.pop();
				int newI;
				if(LorN >= 'A' && LorN <= 'Z')
					newI = translateStoM(LorN);
				else
					newI = Character.getNumericValue(LorN);
				store.push(newI);
			}

			int fop = store.pop(); //first operand
			int sop = store.pop(); //second operand
			
			if(stack.peek() == '*') {
				int num = fop*sop;
				store.push(num);
				stack.pop();
			}
			else if(stack.peek() == '+') {
				int num = fop+sop;
				store.push(num);
				stack.pop();
			}
		}
		return store.peek();
	}
	
	//translates symbol to mass using atom directory
	private static int translateStoM(char c) {
		for(int i=0; i<AtomDirec.size(); i++) {
			if(AtomDirec.get(i).getSymb() == c)
				return (AtomDirec.get(i).getMass());
			}
		return 0;
	}

	//postfix expression is obtained in reverse order by algorithm, this method corrects it
	private static ArrayList<Character> reverseArrList(ArrayList<Character> list) {
		ArrayList<Character> reverse = new ArrayList<Character>();
		for(int i=list.size()-1; i>=0; i--) {
			reverse.add(list.get(i));
		}
		return reverse;
	}
}

class Atom {
	private char symb;
	private int mass;

	public Atom(char symb, int mass) {
		this.symb = symb;
		this.mass = mass;
	}

	public char getSymb() {
		return this.symb;
	}

	public int getMass() {
		return this.mass;
	}
}
	
class Stack<E> {
	private ArrayList<E> list;

	public Stack() {
		list = new ArrayList<E>();
	}

	public boolean empty() {
		return (list.size() == 0);
	}

	public void push(E elem) {
		list.add(elem);
	}

	public E peek() throws EmptyStackException {
		try {
			return list.get(list.size()-1);
		}
		catch (NoSuchElementException e) {
			throw new EmptyStackException();
		}
	}

	public E pop() throws EmptyStackException {
		E obj = peek();
		int id = list.lastIndexOf(obj);
		list.remove(id);
		return obj;
	}

	public int getSize() {
		return list.size();
	}

	public void setArrList(ArrayList<E> list) {
		this.list = list;
	}

	public ArrayList<E> getArrList() {
		return this.list;
	}
}
