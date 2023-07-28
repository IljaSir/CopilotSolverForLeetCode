class Solution {
public:
    double getProbability(vector<int>& balls) {
        
        int n = balls.size();
        int total = 0;
        vector<int> cnt(1 << n, 0);
        for(int mask = 0; mask < (1 << n); mask++) {
            for(int i = 0; i < n; i++) {
                if(mask & (1 << i)) {
                    cnt[mask] += balls[i];
                }
            }
            if(cnt[mask] == total) {
                cnt[mask] = 0;
            }
            total = max(total, cnt[mask]);
        }
        vector<vector<double>> dp(1 << n, vector<double>(total + 1, 0.0));
        dp[0][0] = 1.0;
        for(int mask = 0; mask < (1 << n); mask++) {
            for(int i = 0; i <= total; i++) {
                if(dp[mask][i] == 0.0) {
                    continue;
                }
                for(int j = 0; j < n; j++) {
                    if(mask & (1 << j)) {
                        continue;
                    }
                    int nextMask = mask | (1 << j);
                    int nextCnt = i + balls[j];
                    dp[nextMask][nextCnt] += dp[mask][i] / __builtin_popcount(nextMask);
                }
            }
        }
        double ans = 0.0;
        for(int mask = 0; mask < (1 << n); mask++) {
            ans += dp[mask][cnt[mask]] * dp[(1 << n) - 1 - mask][cnt[(1 << n) - 1 - mask]];
        }
        return ans;
    }
};