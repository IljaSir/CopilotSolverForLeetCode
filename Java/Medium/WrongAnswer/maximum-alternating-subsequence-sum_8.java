class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long sum = 0;
        long odd = 0;
        long even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even = Math.max(even + nums[i], odd);
                sum = Math.max(sum, even);
            } else {
                odd = Math.max(odd + nums[i], even);
                sum = Math.max(sum, odd);
            }
        }
        return sum;
    }
}