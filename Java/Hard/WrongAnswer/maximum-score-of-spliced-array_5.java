class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[n + 1];
        int[] ps1 = new int[n + 1];
        int[] ps2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps1[i] = ps1[i - 1] + nums1[i - 1];
            ps2[i] = ps2[i - 1] + nums2[i - 1];
        }
        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            max[i] = Math.max(max[i - 1], ps1[i]);
        }
        for (int i = 1; i <= n; i++) {
            int l = 0, r = i;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (ps1[i] - ps1[mid] > ps2[i] - ps2[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l == 0) {
                dp[i] = Math.max(dp[i - 1], ps1[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], max[l - 1] + ps2[i] - ps2[l - 1]);
            }
        }
        return dp[n];
    }
}