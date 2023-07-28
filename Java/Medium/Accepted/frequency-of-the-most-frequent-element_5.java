class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        long sum = 0;
        int max = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (nums[i] * (i - j + 1L) - sum > k) {
                sum -= nums[j];
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}