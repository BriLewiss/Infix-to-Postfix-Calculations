
// Class: Data Structures Section 02
// Term: Spring
// Name: Brianna Lewis
// Program Number: 3
// IDE: Eclipse

import java.util.Scanner;

public class ExprBriannaLewis { 
	
	public static int precedence (char ch) {
		switch(ch) {
		case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        case '^':
            return 3;
        }
        return -1;
	}
	
	public static String infixToPostfix (String infix) {
		MyStackBriannaLewis<Character> myStack = new MyStackBriannaLewis<Character> ();
		String result = new String("");
		
		for (int i = 0; i<infix.length();i++) {
			char token = infix.charAt(i);
			
			if(Character.isLetterOrDigit(token))
			{
				result += token;
			}
			else if (token == '+' || token == '-' || token == '*' || token == '/' || token == '^') {
				while (!myStack.isEmpty() && precedence(token) <= precedence(myStack.peek())) {
					char operator = myStack.pop();
					result += operator;
					
				}
				myStack.push(token);
			}
			else if (token == '(')
			{
				myStack.push(token);
			}
			else if (token == ')') {
				while (!myStack.isEmpty() && myStack.peek() != '(') {
					char operator = myStack.pop();
					result += operator;
				}
				myStack.pop();
			}
		}
		while (!myStack.isEmpty()) {
			result += myStack.pop();
		}
		return result;
	}

	public static double postfixEval(String postfix) {
		MyStackBriannaLewis <Double> myStack = new MyStackBriannaLewis <Double>();
		double result = 0.0;
		double a = 0;
		double b = 0;
		for (int i = 0; i < postfix.length(); i++) {
			char token = postfix.charAt(i);
		
			
			if (Character.isLetterOrDigit(token)){
				myStack.push((double)Integer.parseInt(String.valueOf(token)));
			}
			
			switch(token) {
			case '+':
				a = myStack.pop();
				b = myStack.pop();
				result = b + a;
				myStack.push(result);
				break;
			case '-':
				a = myStack.pop();
				b = myStack.pop();
				result = b - a;
				myStack.push(result);
				break;
			case '/':
				a = myStack.pop();
				b = myStack.pop();
				result = b / a;
				myStack.push(result);
				break;
			case '*':
				a = myStack.pop();
				b = myStack.pop();
				result = b * a;
				myStack.push(result);
				break;
			case '^': 
				a = myStack.pop();
				b = myStack.pop();
				result = Math.pow(b, a);
				myStack.push(result);
				break;
			
			}
		}
		
		Double number = myStack.peek();
		
		return number;
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		String enterMore = "Y";
		
		while (enterMore.equals("Y")) {
			System.out.println("Enter an infix:");
			String infix = sc.next();
			String postfix = infixToPostfix(infix);
			System.out.println("Postfix Expression: " + postfix);
			System.out.println("Result value: " + postfixEval(postfix));
			System.out.println("Do you want to continue? (Y/N)");
			enterMore = sc.next();
		
		}
		
	}

}
