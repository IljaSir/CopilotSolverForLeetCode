class Solution {
public:
    int longestStrChain(vector<string>& words) {
        
        int n = words.size();
        sort(words.begin(), words.end(), [](string& a, string& b) { return a.size() < b.size(); });
        vector<int> dp(n, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].size() == words[j].size()) continue;
                if (words[i].size() - words[j].size() > 1) break;
                if (isPredecessor(words[i], words[j])) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
    bool isPredecessor(string& a, string& b) {
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a[i] == b[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == b.size();
    }
};