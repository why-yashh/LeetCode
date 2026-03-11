import java.util.*;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        Arrays.sort(rides, (a, b) -> a[1] - b[1]); // sort by end
        
        int m = rides.length;
        long[] dp = new long[m];
        
        dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
        
        for (int i = 1; i < m; i++) {
            
            long profit = rides[i][1] - rides[i][0] + rides[i][2];
            
            int j = binarySearch(rides, i, rides[i][0]);
            
            if (j != -1)
                profit += dp[j];
            
            dp[i] = Math.max(dp[i-1], profit);
        }
        
        return dp[m-1];
    }
    
    private int binarySearch(int[][] rides, int right, int start) {
        
        int l = 0, r = right - 1;
        int ans = -1;
        
        while (l <= r) {
            
            int mid = l + (r - l) / 2;
            
            if (rides[mid][1] <= start) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }
}