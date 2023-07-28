class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        int[][] freq = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                freq[nums1[i]][0]++;
                freq[nums1[i]][1]++;
            } else {
                freq[nums1[i]][0]++;
                freq[nums2[i]][1]++;
            }
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (freq[i][0] == n && freq[i][1] == n) return -1;
            dp[i] = Math.min(freq[i][0], freq[i][1]);
        }
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= n; j++) {
                    if (j != i) {
                        min = Math.min(min, dp[j]);
                    }
                }
                ans += min + i;
            } else {
                ans += i;
            }
        }
        return ans;
    }
}