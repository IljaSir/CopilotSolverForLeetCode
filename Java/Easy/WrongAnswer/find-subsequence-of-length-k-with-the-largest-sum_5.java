class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[k];
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (j - i + 1 == k) {
                    if (sum > max) {
                        max = sum;
                        start = i;
                    }
                    sum -= nums[j - k + 1];
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = nums[start + i];
        }
        return res;
    }
}