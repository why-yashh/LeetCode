class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        
        for (int top = 0; top < m; ++top) {
            int[] colSum = new int[n];
            for (int bot = top; bot < m; ++bot) {
                for (int c = 0; c < n; ++c) {
                    colSum[c] += matrix[bot][c];
                }
                TreeSet<Integer> prefix = new TreeSet<>();
                prefix.add(0);
                int prefixSum = 0;
                for (int sum : colSum) {
                    prefixSum += sum;
                    Integer ceil = prefix.ceiling(prefixSum - k);
                    if (ceil != null) {
                        ans = Math.max(ans, prefixSum - ceil);
                    }
                    prefix.add(prefixSum);
                }
            }
        }
        return ans;
    }
}
