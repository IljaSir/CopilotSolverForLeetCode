class Solution {
public:
    int captureForts(vector<int>& forts) {
        
        int n = forts.size();
        vector<int> dp(n, 0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (forts[i] == 1) {
                int j = i, k = i;
                int cnt = 0;
                while (j >= 0 && forts[j] == 0) {
                    --j;
                    ++cnt;
                }
                while (k < n && forts[k] == 0) {
                    ++k;
                    ++cnt;
                }
                for (int l = j + 1; l < k; ++l) {
                    dp[l] = cnt;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};