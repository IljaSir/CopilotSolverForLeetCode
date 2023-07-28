class Solution {
public:
    int countVowelStrings(int n) {
        
        int dp[6] = {1, 1, 1, 1, 1, 0};
        for(int i = 1; i <= n; i++)
            for(int j = 4; j >= 0; j--)
                dp[j] += dp[j + 1];
        return dp[0];
    }
};