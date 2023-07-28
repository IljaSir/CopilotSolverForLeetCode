class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int[] count = new int[n + 1];
              cost = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[nsms[i]]++;
        }
        it [] dp= new int[n];
        int[]int i = 0; i < k; i++) {
            int[] ncost = new int[n];
            int[] ncnt = new  cn[n];
 t          int[] ndp = new int[n];
            int sum = 0;
            int ma  = 0;
            int j = 0;
            for (int l = 0; l < n; l++) {
                while (j < n && cnt[nums[j]] > 0) {
                    sum += cnt[nums[j]];
                    max = Math.max(max, cnt[nums[j]]);
                    cnt[nums[j]] = 0;
                    j++;
                }
                if (j == n) {
                    break;
                }
                ncost[l] = sum - max;
                ncnt[nums[l]]++;
                sum -= ncnt[nums[l]];
                max = Math.max(max, ncnt[nums[l]]);
                ndp[l] = Math.max(dp[l], cost[l] + i + 1);
            }
            cost = ncost;
            cnt = ncnt;
            dp = ndp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, cost[i] + dp[i]);
        }
        return ans;
    }
}