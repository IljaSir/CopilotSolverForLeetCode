class Solution {
public:
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special, vector<int>& needs) {
        
        int n = needs.size();
        int m = special.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < m; j++) {
                int tmp = i;
                for (int k = 0; k < n; k++) {
                    if (special[j][k] > needs[k] - (tmp & 1)) {
                   um;
    }
};