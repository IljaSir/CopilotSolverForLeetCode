class Solution {
public:
    vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
        
        sort(words.begin(), words.end(), [](string &a, string &b) { return a.size() < b.size(); });
        unordered_set<string> st;
        vector<string> res;
        for (string &word : words) {
            if (wordBreak(word, st)) {
                res.push_back(word);
            }
            st.insert(word);
        }
        return res;
    }
    bool wordBreak(string s, unordered_set<string> &st) {
        int n = s.size();
        vector<bool> dp(n + 1, false);
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && st.count(s.substr(j, i - j))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
};