class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        set<string> dict(words.begin(), words.end());
        vector<string> res;
        for (auto w : words) {
            if (w.empty()) continue;
            int n = w.size();
            vector<bool> dp(n + 1, false);
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dict.count(w.substr(j, i - j)) && dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (dp[n]) res.push_back(w);
        }
        return res;
    }
};