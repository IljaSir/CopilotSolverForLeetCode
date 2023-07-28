class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int result = 0;
        for (int i = 0; i <= n; i++) {
            int j = i + 1;
            while (j <= n && prefix[j] - prefix[i] <= goal) {
                if (prefix[j] - prefix[i] == goal) {
                    result++;
                }
                j++;
            }
        }
        return result;
    }
}