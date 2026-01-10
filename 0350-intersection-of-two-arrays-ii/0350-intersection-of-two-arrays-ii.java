class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count1 = new HashMap<>();
        for(int num:nums1){
            count1.put(num,count1.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : nums2){
            int c1 = count1.getOrDefault(num, 0);
            if(c1>0){
                result.add(num);
                count1.put(num, c1 -1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}