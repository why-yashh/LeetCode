import java.util.*;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; 
            }
            return b[0] - a[0]; 
        });

        int maxDefense = 0;
        int weak = 0;

        for (int[] p : properties) {
            int defense = p[1];

            if (defense < maxDefense) {
                weak++;
            }

            maxDefense = Math.max(maxDefense, defense);
        }

        return weak;
    }
}