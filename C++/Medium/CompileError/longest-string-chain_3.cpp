class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        sort(words.begin(), words.end(), [](const string& a, const string& b) {return a.size() < b.size();});
        int n = words.size();
        vector<int> dp(n, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (words[j].size() - words[i].size() > 1) break;
                if (isPredecessor(words[i], words[j])) dp[j] = max(dp[j], dp[i] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};