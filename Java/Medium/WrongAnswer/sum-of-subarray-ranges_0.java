class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i] * (i + 1) * (nums.length - i);
        }
        return sum;
    }
}