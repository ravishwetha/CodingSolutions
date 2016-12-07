//This program reads data in different formats and performs the respective operations

import java.util.*;

public class Reading {

	public static int operate(String op, int operand1, int operand2) {
		if (op.equals("ADD")) {
			return operand1 + operand2;
		}
		else if(op.equals("SUB")) {
			return operand1 - operand2;
		}
		else if(op.equals("MUL")) {
			return operand1 * operand2;
		}
		else {
			System.out.println("error");
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String opDescLine;
		String[] opDesc = new String[3];
		int op1;
		int op2;
		int ans;

		String reading = sc.nextLine();
		switch (reading) {
			case "LIMIT": int numOp = sc.nextInt();
			              sc.nextLine();
			              for(int i=0; i<numOp; i++) {
							  opDescLine = sc.nextLine();
							  opDesc = opDescLine.split("\\s+");
							  op1 = Integer.parseInt(opDesc[1]);
							  op2 = Integer.parseInt(opDesc[2]);
							  ans = operate(opDesc[0], op1, op2);
							  System.out.println(ans);
						  }
						  break;

			case "SENTINEL": do {
				                opDescLine = sc.nextLine();
							    opDesc = opDescLine.split("\\s+");
								if(opDesc[0].equals("-1")) {
									break;
								}
							    op1 = Integer.parseInt(opDesc[1]);
							    op2 = Integer.parseInt(opDesc[2]);
							    ans = operate(opDesc[0], op1, op2);
							    System.out.println(ans);
						     } while(true);
							 break;

			case "EOF": while(sc.hasNextLine()) {
				              opDescLine = sc.nextLine();
							  opDesc = opDescLine.split("\\s+");
							  op1 = Integer.parseInt(opDesc[1]);
							  op2 = Integer.parseInt(opDesc[2]);
							  ans = operate(opDesc[0], op1, op2);
							  System.out.println(ans);
			            }
						break;

			default: System.out.println("error");
		}
	}
}
