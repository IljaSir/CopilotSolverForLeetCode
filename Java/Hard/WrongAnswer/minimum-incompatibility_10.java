class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int[] mask = new int[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            int[] count = new int[17];
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    count[nums[j]]++;
                    if (count[nums[j]] > 1) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                mask[i] = i;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        mask[i] = mask[i] & ~(1 << j);
                    }
                }
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] < 0) {
                continue;
            }
            for (int j = mask[i]; j > 0; j = (j - 1) & mask[i]) {
                if (Integer.bitCount(j) % (n / k) == 0) {
                    int next = i | j;
                    int min = Integer.MAX_VALUE;
                    int max = Integer.MIN_VALUE;
                    for (int l = 0; l < n; l++) {
                        if ((j & (1 << l)) > 0) {
                            min = Math.min(min, nums[l]);
                            max = Math.max(max, nums[l]);
                        }
                    }
                    if (dp[next] < 0) {
                        dp[next] = dp[i] + max - min;
                    } else {
                        dp[next] = Math.min(dp[next], dp[i] + max - min);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}