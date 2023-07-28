class Solution {
public:
    int numDecodings(string s) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        dp[0] = 1; stoi(s.substr(i-2, 2)) <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
};