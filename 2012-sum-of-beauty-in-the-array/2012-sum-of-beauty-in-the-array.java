class Solution {
    public int sumOfBeauties(int[] nums) {
        int sum = 0;
        int n = nums.length;

        int[] minSuffix = new int[n];
        minSuffix[n-1] = nums[n-1];

        for(int i=n-2; i>=0; i--){
            minSuffix[i] = Math.min(minSuffix[i+1], nums[i]);
        }

        int prefix = nums[0];
        for(int i=1; i<n-1; i++){
            if(prefix < nums[i] && nums[i] < minSuffix[i+1]){
                sum += 2;
                prefix = Math.max(prefix, nums[i]);
            }
            else if(nums[i-1] < nums[i] && nums[i] < nums[i+1]){
                sum += 1;
                prefix = Math.max(prefix, nums[i]);
            }
            else{
                prefix = Math.max(prefix, nums[i]);
            }
        }
        return sum;
    }
}