class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];

        // First element remains the same
        runningSum[0] = nums[0];

        // Calculate the running sum
        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }

        return runningSum;
    }
}
