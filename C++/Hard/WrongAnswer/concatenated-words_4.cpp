class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        vector<string> res;
        unordered_set<string> dict(words.begin(), words.end());
        for (auto &w : words) {
            int n = w.size();
            vector<bool> dp(n + 1, false);
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                if (dp[i]) {
                    for (int j = i + 1; j <= n; j++) {
                        if (dict.count(w.substr(i, j - i))) {
                            dp[j] = true;
                        }
                    }
                }
            }
            if (dp[n]) res.push_back(w);
        }
        return res;
    }
};