class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        int ans = 0;
        unordered_map<string, int> dp;
        sort(words.begin(), words.end(), [](const string& a, const string& b) { return a.size() < b.size(); });
        for (string& w : words) {
            for (int i = 0; i < w.size(); ++i) {
                string pre = w.substr(0, i) + w.substr(i + 1);
                dp[w] = max(dp[w], dp[pre] + 1);
            }
            ans = max(ans, dp[w]);
        }
        return ans;
    }
};