class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int i = 0, j = 0;
        long sum = 0;
        int max = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum + k < (long)nums[j] * (j - i + 1)) {
                sum -= nums[i];
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}