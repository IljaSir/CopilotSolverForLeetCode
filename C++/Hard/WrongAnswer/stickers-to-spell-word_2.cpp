class Solution {
public:
    int minStickers(vector<string>& stickers, string target) {
        
        int n = stickers.size();
        vector<vector<int>> sticker(n, vector<int>(26, 0));
        for (int i = 0; i < n; ++i) {
            for (char c : stickers[i]) {
                ++sticker[i][c - 'a'];
            }
        }
        vector<int> dp(1 << target.size(), INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < dp.size(); ++i) {
            if (dp[i] == INT_MAX) continue;
            for (int j = 0; j < n; ++j) {
                int cur = i;
                for (int k = 0; k < target.size(); ++k) {
                    if ((cur >> k) & 1) continue;
                    if (sticker[j][target[k] - 'a'] == 0) continue;
                    cur |= (1 << k);
                }
                dp[cur] = min(dp[cur], dp[i] + 1);
            }
        }
        return dp.back() == INT_MAX ? -1 : dp.back();
    }
};