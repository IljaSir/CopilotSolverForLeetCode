class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) (i + 1) * (nums.length - i) * nums[i];
        }
        return sum;
    }
}