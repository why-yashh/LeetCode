class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for(int num: nums){
            total += getSumIfFourDivisors(num);
        }
        return total;
    }
    private int getSumIfFourDivisors(int num){
        int count = 2;
        int sum = num + 1 ;
        for(int i = 2; i * i <= num; ++i){
            if(num % i == 0){
                ++count;
                sum += i;
                if(i * i != num){
                    ++count;
                    sum += num / i;
                }
            }
        }
        return count == 4 ? sum : 0;
    }
}