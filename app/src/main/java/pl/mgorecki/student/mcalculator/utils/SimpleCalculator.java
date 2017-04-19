package pl.mgorecki.student.mcalculator.utils;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by emigore on 2017-04-16.
 */
public class SimpleCalculator {

    private final static String OPERATOR_REGEX = InfixExpressionEvaluator.OPERATOR_REGEX;
    private final static String OPERAND_REGEX = InfixExpressionEvaluator.OPERAND_REGEX;
    private static final Map<String, Integer> PRIORITIES = Collections.unmodifiableMap(
            new HashMap<String, Integer>() {{
                put("+", 1);
                put("-", 1);
                put("*", 2);
                put("/", 2);
                put("^", 2);
            }}
    );
    private Stack<String> stack = new Stack<>();

    public void calculationStep(String currentWord){
        if(Pattern.matches(OPERAND_REGEX,currentWord)){
            //jesli peek jest operatorem lub stos jest pusty, to wrzuc liczbe na stos
            System.out.println("Liczba");
            if(stack.isEmpty() || Pattern.matches(OPERATOR_REGEX,stack.peek())){
                stack.push(currentWord);
            }
        }else if(Pattern.matches(OPERATOR_REGEX,currentWord)){
            System.out.println("Operator");
            if(stack.size() >= 3 ){
                calculate();
            }
            if(Pattern.matches(OPERAND_REGEX,stack.peek())){
                stack.push(currentWord);
            }
        }else if(currentWord.equals("=")){
            try {
                calculate();
            }catch(EmptyStackException e){
                System.out.println("calculate() failed - not enough operands");
            }
        }else if(currentWord.equals("CE")){
            if(!stack.isEmpty()){
                stack.pop();
            }
        }else if(currentWord.equals("C")){
            stack.clear();
        }
    }

    public String getCurrentResult(){
        try{
            if(Pattern.matches(OPERATOR_REGEX,stack.peek())){
                int stackSize = stack.size();
                return stack.elementAt(stackSize-2);
            }
            return stack.peek();
        }catch(EmptyStackException e) {
            return "Empty stack.";
        }
    }


    private void calculate() {
        try {
            Double op1 = Double.parseDouble(stack.pop());
            String operator = stack.pop();
            Double op2 = Double.parseDouble(stack.pop());
            Double result = null;

            switch (operator) {
                case "+":
                    result = op1 + op2;
                    break;
                case "-":
                    result = op2 - op1;
                    break;
                case "*":
                    result = op1 * op2;
                    break;
                case "^":
                    result = Math.pow(op2,op1);
                    break;
                case "/":
                    if (op2 != 0) {
                        result = op2 / op1;
                    }
                    break;
                default:
                    System.out.println("Invalid division!");
                    return;
            }
            stack.push(String.valueOf(result));
        }catch(EmptyStackException e){
            System.out.println("Cannot calculate - no operands on stack.");
        }
    }

}
