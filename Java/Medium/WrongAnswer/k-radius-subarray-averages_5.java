class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int[] avgs = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            avgs[i] = i < k - 1 ? -1 : sum / k;
        }
        return avgs;
    }
}