class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        // dp[i][j] means the shortest superstring of words in i, ending with j
        vector<vector<string>> dp(1<<n, vector<string>(n, ""));
        // overlap[i][j] means the overlap between words[i] and words[j]
        vector<vector<int>> overlap(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int m = min(words[i].size(), words[j].size());
                for (int k = m; k >= 0; k--) {
                    if (words[i].substr(words[i].size()-k) == words[j].substr(0, k)) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) dp[1<<i][i] = words[i];
        for (int i = 0; i < 1<<n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j)) == 0) continue;
                for (int k = 0; k < n; k++) {
                    if ((i&(1<<k)) > 0 || overlap[j][k] == 0) continue;
                    string s = dp[i|(1<<k)][k];
                    if (dp[i][j].size() + s.size() - overlap[j][k] < dp[i|(1<<k)][j].size() || dp[i|(1<<k)][j] == "") {
                        dp[i|(1<<k)][j] = dp[i][j] + s.substr(overlap[j][k]);
                    }
                }
            }
        }
        string res = dp[(1<<n)-1][0];
        for (int i = 0; i < n; i++) {
            if (dp[(1<<n)-1][i].size() < res.size()) res = dp[(1<<n)-1][i];
        }
        return res;
    }
};