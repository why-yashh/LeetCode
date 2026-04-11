import java.util.HashMap;

class Solution {
    public int longestWPI(int[] hours) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if(sum > 0){
                ans = i+1;
            } else if(map.containsKey(sum-1)){
                ans = Math.max(ans, i-map.get(sum-1));
            }
            map.put(sum, map.getOrDefault(sum, i));
        }
        return ans;
    }
}