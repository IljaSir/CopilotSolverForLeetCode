class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        sort(words.begin(), words.end(), [](const string& a, const string& b) { return a.size() < b.size(); });
        unordered_map<string, int> dp;
        int ans = 0;
        for (auto& w : words) {
            int best = 0;
            for (int i = 0; i < w.size(); ++i) {
                string prev = w.substr(0, i) + w.substr(i + 1);
                best = max(best, dp[prev] + 1);
            }
            dp[w] = best;
            ans = max(ans, best);
        }
        return ans;
    }
};