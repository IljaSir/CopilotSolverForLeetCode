class Solution {
public:
    int numberOfWays(string corridor) {
        
        int n = corridor.size();
        int mod = 1e9+7;
        int dp0 = 1, dp1 = 0;
        for(int i = 0; i < n; i++) {
            if(corridor[i] == 'S') {
                dp1 = (dp1 + dp0) % mod;
            }
            else {
                dp0 = (dp0 + dp1) % mod;
            }
        }
        return dp0 - 1;
    }
};