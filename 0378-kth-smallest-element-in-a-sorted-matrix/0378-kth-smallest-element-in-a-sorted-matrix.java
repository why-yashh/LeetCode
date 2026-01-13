class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);
            
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int countLessEqual(int[][] matrix, int val) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        int row = rows - 1;
        int col = 0;
        
        while (row >= 0 && col < cols) {
            if (matrix[row][col] <= val) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        
        return count;
    }
}
