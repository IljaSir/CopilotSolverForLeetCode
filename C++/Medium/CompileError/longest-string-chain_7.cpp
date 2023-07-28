class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        sort(words.begin(), words.end(), [&](string& a, string& b) { return a.size() < b.size(); });
        int n = words.size();
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0 && words[i].size() - words[j].size() < 2; --j) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};