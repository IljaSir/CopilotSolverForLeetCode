class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1;
        long sum = 0;
        int l = 0;
        for (int r = 1; r < n; r++) {
            sum += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (sum > k) {
                sum -= nums[r] - nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}