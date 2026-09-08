import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                int top = stack.peek();

                // Top asteroid is smaller
                if (top < -asteroid) {
                    stack.pop();
                }
                // Both are same size
                else if (top == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                // Top asteroid is larger
                else {
                    destroyed = true;
                    break;
                }
            }

            // Current asteroid survives
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert Stack to array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}