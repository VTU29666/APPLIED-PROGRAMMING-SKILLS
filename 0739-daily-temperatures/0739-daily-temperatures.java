class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        // Stack stores indices
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {

            // Find warmer temperature for previous days
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) {
                int prev = stack[top--];
                answer[prev] = i - prev;
            }

            // Store current day's index
            stack[++top] = i;
        }

        return answer;
    }
}