class Solution {
public:
    vector<int> waysToFillArray(vector<vector<int>>& queries) {
        
        int n = 10001;
        vector<int> dp(n, 0);
        vector<int> res;
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=2*i; j<n; j+=i){
                dp[j] = (dp[j] + dp[i]) % 1000000007;
            }
        }
        for(auto q : queries){
            int a = q[0];
            int b = q[1];
            res.push_back((dp[b]*a)%1000000007);
        }
        return res;
    }
};