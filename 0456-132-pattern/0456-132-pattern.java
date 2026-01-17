class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // nums[k]

        for (int i = n - 1; i >= 0; i--) {
            // nums[i] is nums[i] (the "1")
            if (nums[i] < third) {
                return true;
            }

            // Pop all smaller elements and update third
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            // nums[i] becomes a potential nums[j]
            stack.push(nums[i]);
        }

        return false;
    }
}
