import java.util.List;

/*
Problem: LeetCode 120 - Triangle
Link: https://leetcode.com/problems/triangle/

Approach (Top-down DP with memoization / recursion):
- Use recursion to explore the two choices at each element (move down or down-right).
- Cache results in a memo table to avoid recomputation (memo[i][j] stores min path sum from (i,j) to bottom).

Time Complexity: O(n^2) where n is the number of rows (each triangle element computed once)
Space Complexity: O(n^2) for the memo table plus O(n) recursion depth (call stack). This can be reduced by using bottom-up DP or a 1D array.
*/
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] memo = new Integer[n][n];
        return helper(triangle, 0, 0, memo);
    }

    private int helper(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        if (i == triangle.size()) return 0;
        if (memo[i][j] != null) return memo[i][j];

        //logic
        int currentValue = triangle.get(i).get(j);
        int case1 = currentValue + helper(triangle, i + 1, j, memo);
        int case2 = currentValue + helper(triangle, i + 1, j + 1, memo);
        memo[i][j] = Math.min(case1, case2);
        return memo[i][j];
    }
}
