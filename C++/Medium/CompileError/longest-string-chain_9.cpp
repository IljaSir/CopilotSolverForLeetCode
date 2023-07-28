class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        const int N = words.size();
        sort(words.begin(), words.end(), [](const string& a, const string& b) { return a.size() < b.size(); });
        vector<int> dp(N, 1);
        int ans = 1;
        for (int i = 1; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (words[i].size() - words[j].size() > 1) continue;
                if (check(words[i], words[j])) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};