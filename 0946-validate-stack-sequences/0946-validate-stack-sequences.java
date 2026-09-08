import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int x : pushed) {

            // Push the element
            stack.push(x);

            // Pop whenever the top matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If all elements were popped, sequence is valid
        return j == popped.length;
    }
}