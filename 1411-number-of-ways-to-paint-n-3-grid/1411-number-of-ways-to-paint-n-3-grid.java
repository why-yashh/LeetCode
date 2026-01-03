class Solution {
    public int numOfWays(int n) {
        final int MOD = 1000000007;
        long a = 6; // ways ending with ABA pattern
        long b = 6; // ways ending with ABC pattern
        
        for (int i = 1; i < n; ++i) {
            long na = (3 * a + 2 * b) % MOD;
            long nb = (2 * a + 2 * b) % MOD;
            a = na;
            b = nb;
        }
        
        return (int) ((a + b) % MOD);
    }
}

