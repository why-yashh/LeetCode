import java.util.*;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        Arrays.sort(capacity);  // ascending
        int boxes = 0;
        int sum = 0;

        // start from largest capacity
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            boxes++;
            if (sum >= totalApples) {
                return boxes;
            }
        }

        return boxes;  // guaranteed possible
    }
}