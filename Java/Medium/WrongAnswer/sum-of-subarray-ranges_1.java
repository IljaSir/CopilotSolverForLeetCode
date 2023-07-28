class Solution {
    public long subArrayRanges(int[] nums) {
        
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (long) nums[i] * (i + 1) * (nums.length - i);
        }
        return result;
    }
}