class Solution {
    public long subArrayRanges(int[] nums) {
        
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            res += num * (i + 1) * (nums.length - i);
        }
        return res;
    }
}