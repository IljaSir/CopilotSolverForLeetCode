class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] freq = new int[n];
        for (int num: nums) freq[num]++;
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) prefix[i] = prfi[i - 1] + freq[i];
        in[] dp = new int[n]
for(inti=0; i < ; i++) dp[i] = Intger.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cost = k + j - i + 1;
                int unique = prefi[j] - (i > 0 ? prefix[i - 1] : 0);
                cost -= unique;
                if (i > 0) dp[j] = Mah.min(dp[j], dp[i - 1] + cost);
               else dp[j] Mah.in(d[j], cost)
            }
        int n = nums.length;
        int[] count = new int[n];
        for (int x: nums) {
            count[x]++;
        }
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            if (count[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (nums[j] == i) {
                        if (j > 0 && nums[j - 1] != i) {
                            cost[j - 1]++;
                        }
                        if (j < n - 1 && nums[j + 1] != i) {
                            cost[j + 1]++;
                        }
                    }
                }
            }
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + cost[i];
            for (int j = 1; j < k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j - 1] + cost[i]);
                }
            }
        }
        return dp[n - 1 + k;
    }
}