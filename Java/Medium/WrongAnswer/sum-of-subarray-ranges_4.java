class Solution {
    public long subArrayRanges(int[] nums) {
        
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i] * (i + 1) * (n - i);
        }
        return sum;
    }
}