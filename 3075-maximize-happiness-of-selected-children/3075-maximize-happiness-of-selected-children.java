import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long total = 0;
        int n = happiness.length;

        for (int i = 0; i < k; i++) {
            long value = happiness[n - 1 - i] - i;
            if (value <= 0) break;
            total += value;
        }

        return total;
    }
}