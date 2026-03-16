class Solution {
    public int numRookCaptures(char[][] board) {
        
        int rookRow = 0;
        int rookCol = 0;
        
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'R'){
                    rookRow = i;
                    rookCol = j;
                }
            }
        }
        
        int count = 0;
        
        int[][] directions = {
            {-1,0}, 
            {1,0},  
            {0,-1}, 
            {0,1}   
        };
        
        for(int[] d : directions){
            
            int r = rookRow + d[0];
            int c = rookCol + d[1];
            
            while(r >= 0 && r < 8 && c >= 0 && c < 8){
                
                if(board[r][c] == 'B') break;
                
                if(board[r][c] == 'p'){
                    count++;
                    break;
                }
                
                r += d[0];
                c += d[1];
            }
        }
        
        return count;
    }
}