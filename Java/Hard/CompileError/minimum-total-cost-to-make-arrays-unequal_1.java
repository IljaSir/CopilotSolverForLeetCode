class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                l1.add(nums1[i]);
                l2.add(nums2[i]);
            }
        }
        n = l1.size();
        if (n == 0) {
            return 0;
        }
        long[][] dp = new long[n][3];
        dp[0][0] = Math.min(l1.get(0), l2.get(0));
        dp[0][1] = Math.min(l1.get(0), l2.get(0)) + 1;
        dp[0][2] = Math.min(l1.get(0), l2.get(0)) + 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + Math.min(l1.get(i), l2.get(i));
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + Math.min(l1.get(i), l2.get(i)) + 1;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][2]) + Math.min(l1.get(i), l2.get(i)) + 1;
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
    }
}