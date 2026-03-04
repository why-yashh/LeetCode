import java.util.*;

class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 1) {
                    int r = i, c = j;

                    // find bottom boundary
                    while(r + 1 < m && land[r + 1][j] == 1) r++;

                    // find right boundary
                    while(c + 1 < n && land[i][c + 1] == 1) c++;

                    res.add(new int[]{i, j, r, c});

                    // mark visited
                    for(int x = i; x <= r; x++) {
                        for(int y = j; y <= c; y++) {
                            land[x][y] = 0;
                        }
                    }
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}