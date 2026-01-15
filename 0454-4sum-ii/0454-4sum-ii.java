class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum12 = new HashMap<>();
        
        // Precompute all sums nums1[i] + nums2[j]
        for (int i : nums1) {
            for (int j : nums2) {
                int s = i + j;
                sum12.put(s, sum12.getOrDefault(s, 0) + 1);
            }
        }
        
        int count = 0;
        // Check for each nums3[k] + nums4[l] if -s exists
        for (int k : nums3) {
            for (int l : nums4) {
                int target = -(k + l);
                count += sum12.getOrDefault(target, 0);
            }
        }
        
        return count;
    }
}
