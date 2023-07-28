class Solution {
public:
    string shortestCommonSupersequence(string str1, string str2) {
        
        int len1 = str1.size();
        int len2 = str2.size();
        vector<vector<int>> dp(len1+1, vector<int>(len2+1, 0));
        for (int i=1; i<=len1; ++i) {
            for (int j=1; j<=len2; ++j) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = len1, j = len2;
        string res;
        while (i>0 && j>0) {
            if (str1[i-1] == str2[j-1]) {
                res.push_back(str1[i-1]);
                --i;
                --j;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    res.push_back(str1[i-1]);
                    --i;
                } else {
                    res.push_back(str2[j-1]);
                    --j;
                }
            }
        }
        while (i>0) {
            res.push_back(str1[i-1]);
            --i;
        }
        while (j>0) {
            res.push_back(str2[j-1]);
            --j;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};