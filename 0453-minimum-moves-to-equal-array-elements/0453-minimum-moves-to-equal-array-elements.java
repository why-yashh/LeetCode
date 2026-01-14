class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 0) return 0;

        int minVal = Integer.MAX_VALUE;
        for(int num : nums){
            minVal = Math.min(minVal, num);
        }
        int moves = 0;
        for(int num : nums){
            moves += num -minVal;
        }
        return moves;
    }
}