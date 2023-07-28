class Solution {
public:
    int maxHappyGroups(int batchSize, vector<int>& groups) {
        
        int n = groups.size();
        vector<int> cnt(batchSize, 0);
        for (int i = 0; i < n; i++) {
            cnt[groups[i] % batchSize]++;
        }
        int ans = cnt[0];
        cnt[0] = 0;
        vector<int> dp(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] == -1) {
                continue;
            }
            int remain = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    remain += groups[j];
                }
            }
            remain %= batchSize;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    int next = i | (1 << j);
                    int nRemain = (remain + groups[j]) % batchSize;
                    int nCnt = dp[i] + (nRemain == 0);
                    if (dp[next] == -1 || dp[next] < nCnt) {
                        dp[next] = nCnt;
                    }
                }
            }
        }
        return ans + dp[(1 << n) - 1];
    }
};