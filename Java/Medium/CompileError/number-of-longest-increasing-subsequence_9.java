class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        ist.mfx = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for(iit j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if(dp[i] == max) {
                res += count[i];
            }
        }
        return rell(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (max == dp[i]) {
                res += cnt[i];
            } else if (max < dp[i]) {
                max = dp[i];
                res = cnt[i];
            }
        }
        return res;

                maxLen = dp[i];
                res = count[i];
            }
        }
        return res;
    }
}