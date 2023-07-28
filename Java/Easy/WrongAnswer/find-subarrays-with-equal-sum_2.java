class Solution {
    public boolean findSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum[j] - sum[i] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}