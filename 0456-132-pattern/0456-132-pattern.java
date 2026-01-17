import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long maxK = Long.MIN_VALUE;  
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                maxK = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}