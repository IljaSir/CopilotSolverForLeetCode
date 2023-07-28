class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0;
        int max = 0;
        while (j < n) {
            sum += nums[j];
            while (sum + k < (long) (j - i + 1) * nums[j]) {
                sum -= nums[i];
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}