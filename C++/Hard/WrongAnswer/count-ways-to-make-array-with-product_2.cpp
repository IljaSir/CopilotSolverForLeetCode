class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int n = queries.size();
        vector<int> ans(n, 0);
        for(int i = 0; i < n; i++){
            int ni = queries[i][0];
            int ki = queries[i][1];
            vector<int> dp(ki + 1, 0);
            for(int j = 1; j <= ki; j++){
                dp[j] = 1;
            }
            for(int j = 2; j <= ni; j++){
                for(int k = ki; k >= 1; k--){
                    for(int l = k; l >= 1; l--){
                        if(k % l == 0){
                            dp[k] += dp[l];
                            dp[k] %= 1000000007;
                        }
                    }
                }
            }
            ans[i] = dp[ki];
        }
        return ans;
    }
};