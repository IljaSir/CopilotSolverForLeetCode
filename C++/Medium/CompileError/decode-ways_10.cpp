class Solution {
public:
    int numDecodings(string s) {
        
        if (s.size() == 0 || s[0] == '0') {
            return 0;
        }
        int n = s.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = stoi(s.substr(i - 1, 1));
            int second = stoi(s.substr(i - 2, 2))
            if (s[i] == '0') continue;
            int ans1 = dp[i + 1];
            int ans2 = 0;
            if (i < n - 1 && (s[i] == '1' || s[i] == '2' && s[i + 1] < '7')) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
};