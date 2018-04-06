package challenges.linkedLists;

import datastructures.Stack;

public class LinkedListAdder {

    // Add numbers contained within two LinkedLists
    public Stack sum(Stack first, Stack second) {
        // Convert
        int num1 = convertFrom(first);
        int num2 = convertFrom(second);

        // Add
        int sum = num1 + num2;

        // Put back into LinkedList form
        Stack total = convertTo(sum);

        return total;
    }

    private int convertFrom(Stack stack) {
        // Pop the numbers off the stack and build them up into a string, then an int
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int num = stack.pop();
            sb.append(num);
        }

        int result = Integer.parseInt(sb.toString());

        return result;
    }

    private Stack convertTo(int number) {
        // Because we need them in reverse order, store them here first,
        // they flip to reverse order after

        Stack forward = new Stack();
        Stack backward = new Stack();

        // Keep slicing off the digits by dividing by 10 and pushing the remainder
        while (number > 0) {
            forward.push(number % 10);
            number = number / 10;
        }

        // Now put flip them over so they are reversed
        while (!forward.isEmpty()) {
            backward.push(forward.pop());
        }

        return backward;
    }


}
