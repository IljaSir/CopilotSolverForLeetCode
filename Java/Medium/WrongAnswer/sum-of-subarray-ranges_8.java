class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - 0 + 1;
            long right = n - i;
            long total = left * right;
            sum += total * nums[i];
        }
        return sum;
    }
}