class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalAbsSum = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;
        
        for (int[] row : matrix) {
            for (int val : row) {
                int absVal = Math.abs(val);
                totalAbsSum += absVal;
                minAbs = Math.min(minAbs, absVal);
                if (val < 0) negCount++;
            }
        }
        
        return negCount % 2 == 0 ? totalAbsSum : totalAbsSum - 2L * minAbs;
    }
}
