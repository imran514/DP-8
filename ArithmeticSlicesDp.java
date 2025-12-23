/*
Problem: LeetCode 413 - Arithmetic Slices
Link: https://leetcode.com/problems/arithmetic-slices/

Approach (Dynamic Programming):
- Use a dp array where dp[i] stores the number of arithmetic slices ending at position i (as implemented in this file).
- For each position, check whether the triple starting at i forms an arithmetic sequence; if so dp[i] = 1 + dp[i-1] (extend previous), else 0.
- Accumulate dp values into the result.

Time Complexity: O(n) where n = nums.length
Space Complexity: O(n) for the dp array (this can be optimized to O(1) by using a single running counter similar to the greedy solution)
*/
public class ArithmeticSlicesDp {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                if (i == 0) {
                    dp[i] = 1;
                } else {
                    dp[i] = 1 + dp[i - 1];
                }
                result += dp[i];
            } else {
                dp[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlicesDp().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
