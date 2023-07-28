class Solution {
    public boolean findSubarrays(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sum[j + 1] - sum[i] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}