class Solution {
public:
    string shortestSuperstring(vector<string>& words) {
        
        int n = words.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int k = 0;
                for (k = 0; k < min(words[i].size(), words[j].size()); k++) {
                    if (words[i].substr(words[i].size() - k) == words[j].substr(0, k)) {
                        dp[i][j] = k;
                    }
                }
            }
        }
        vector<vector<int>> path(n, vector<int>(1 << n, -1));
        vector<vector<int>> dp2(n, vector<int>(1 << n, 0));
        for (int i = 0; i < n; i++) {
            dp2[i][1 << i] = words[i].size();
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    for (int k = 0; k < n; k++) {
                        if (j != k && i & (1 << k)) {
                            int tmp = dp2[j][i ^ (1 << j)] + words[j].size() - dp[k][j];
                            if (tmp > dp2[k][i]) {
                                dp2[k][i] = tmp;
                                path[k][i] = j;
                            }
                        }
                    }
                }
            }
        }
        int last = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            if (dp2[i][(1 << n) - 1] > max_len) {
                max_len = dp2[i][(1 << n) - 1];
                last = i;
            }
        }
        string ans;
        int tmp = (1 << n) - 1;
        while (last != -1) {
            ans = words[last].substr(words[last].size() - dp[path[last][tmp]][last]) + ans;
            int tmp2 = path[last][tmp];
            tmp ^= (1 << last);
    }
};