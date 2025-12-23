import java.util.List;

/*
Problem: LeetCode 120 - Triangle
Link: https://leetcode.com/problems/triangle/

Approach (Bottom-up DP from bottom row):
- Start from the bottom row and build upwards. dp[i][j] stores the minimum path sum from cell (i,j) to the bottom.
- For each cell, dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1]).
- The answer is dp[0][0]. This can be optimized to O(n) space by using a single 1D array representing the next row.

Time Complexity: O(n^2) where n is number of rows
Space Complexity: O(n^2) for the dp table as implemented; can be optimized to O(n).
*/
public class TriangleDP1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
