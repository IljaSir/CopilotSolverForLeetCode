class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i + firstLen <= n; i++) {
            int a = sum[i+firstLen] - sum[i];
            for (int j = 0; j + secondLen <= n; j++) {
                if (j >= i + firstLen || j + secondLen <= i) {
                    res = Math.max(res, a + sum[j+secondLen] - sum[j]);
                }
            }
        }
        return res;
    }
}