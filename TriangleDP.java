import java.util.List;

/*
Problem: LeetCode 120 - Triangle
Link: https://leetcode.com/problems/triangle/

Approach (Bottom-up DP):
- Build a 2D dp table where dp[i][j] represents the minimum path sum to reach element (i,j) from the top.
- Initialize dp[0][0], then for each row calculate dp values using previous row values. Finally, take the minimum of the last row as the answer.

Time Complexity: O(n^2) where n is the number of rows (process each element once)
Space Complexity: O(n^2) for the dp table; can be optimized to O(n) using a single 1D array (or reusing the input triangle) or O(1) extra space with careful in-place updates.
*/
public class TriangleDP {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][0];
                } else if (i == j) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n-1][i]);
        }
        return  result;
    }
}
