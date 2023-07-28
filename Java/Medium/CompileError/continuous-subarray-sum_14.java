class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        if (n < 2) return false;
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+2; j <= n; j++) {
                int sum = preSum[j] - preSum[i];
                if (k == 0) {
                    if (sum == 0) return true;
                } else {
                    if (sum % k == 0) return true;
                }
            }
        }
        return false;
    }
}
    }
}