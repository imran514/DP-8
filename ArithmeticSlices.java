/*
Problem: LeetCode 413 - Arithmetic Slices
Link: https://leetcode.com/problems/arithmetic-slices/

Approach (Greedy / single-pass):
- Iterate once through the array and check consecutive triples to see if they form an arithmetic sequence (equal differences).
- Maintain a running counter `current` that counts how many arithmetic slices end at the current index. When the triple at i..i+2 continues the previous run, increment `current` and add it to the result; otherwise reset `current` to zero.

Time Complexity: O(n) where n = nums.length (single pass)
Space Complexity: O(1) extra space (only a few integer variables)
*/
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        int current = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                current += 1;
                result += current;
            } else {
                current = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
