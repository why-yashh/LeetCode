class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>(nums.length);
        int curr = 0;

        for(int bit : nums){
            curr = ((curr << 1) + bit) % 5;
            res.add(curr == 0);
        }
        return res;
    }
}