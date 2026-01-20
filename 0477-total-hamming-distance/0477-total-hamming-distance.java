class Solution {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        int n = nums.length;

        for (int bit = 0; bit < 32; bit++) {
            int ones = 0;

            for (int num : nums) {
                if (((num >> bit) & 1) == 1) {
                    ones++;
                }
            }

            result += ones * (n - ones);
        }

        return result;
    }
}
