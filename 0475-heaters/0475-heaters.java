import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                idx = -idx - 1;
            }

            int left = idx > 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            int right = idx < heaters.length ? heaters[idx] - house : Integer.MAX_VALUE;

            radius = Math.max(radius, Math.min(left, right));
        }

        return radius;
    }
}
