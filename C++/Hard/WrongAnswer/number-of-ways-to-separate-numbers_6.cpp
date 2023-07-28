class Solution {
public:
    int numberOfCombinations(string num) {
        
        int n = num.size();
        vector<int> dp(n + 1, 0);
        vector<int> count(n + 1, 0);
        dp[0] = 1;
        count[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (num[j] != '0' && stol(num.substr(j, i - j)) <= 1000000000) {
                    dp[i] = (dp[i] + dp[j]) % 1000000007;
                    count[i] = (count[i] + count[j]) % 1000000007;
                } else {
                    break;
                }
            }
        }
        return count[n];
    }
};