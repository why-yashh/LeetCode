class Solution {
    int dir[][] = {{-1,-1},{-1,1},{1,1},{1,-1}};
    int l=0; int h=0;
    public int lenOfVDiagonal(int[][] grid) {
        int ans = 0; l = grid.length; h = grid[0].length;
        int dp[][][][] = new int[l][h][4][2];
        for(int i=0; i<l; i++){
            for(int j=0; j<h; j++){
                for(int k=0; k<4; k++){
                    dp[i][j][k][0] = -1;
                    dp[i][j][k][1] = -1;
                }
            }
        }
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    for(int d=0; d<4; d++){
                        ans = Math.max(ans,memo(dp,grid,i,j,d,0));
                    }
                }
            }
        }
        return ans;
    }
    public int memo(int dp[][][][],int grid[][], int m, int n, int d, int turn){
        int curr = grid[m][n];
        if(dp[m][n][d][turn] != -1) return dp[m][n][d][turn];
        int row = m + dir[d][0];
        int col = n + dir[d][1];
        int ans = 1;
        //same direction
        if(row >=0 && col >= 0 && row<l && col<h){
            int next = grid[row][col];
            if((curr == 0 && next == 2) || (curr == 2 && next == 0) || (curr == 1 && next == 2)){
                ans = Math.max(ans,1+memo(dp,grid,row,col,d,turn));
            }
        }
        //90 degree turn if not turned
        if(turn == 0){
            int nd = (d+1) % 4;//flip direction
            row = m + dir[nd][0];
            col = n + dir[nd][1]; 
            if(row >=0 && col >= 0 && row<l && col<h){
                int next = grid[row][col];
                if((curr == 0 && next == 2) || (curr == 2 && next == 0)){
                    ans = Math.max(ans,1+memo(dp,grid,row,col,nd,1));
                }
            }
        }
        return dp[m][n][d][turn] = ans;
    }
}