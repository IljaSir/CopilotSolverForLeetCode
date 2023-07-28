class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int m = 30;
        int mod = 1e9 + 7;
        vector<int> cnt(m);
        for(int i = 0; i < n; i++)
            cnt[nums[i] - 1]++;
        vector<int> sq(m);
        for(int i = 0; i < m; i++)
            sq[i] = i * i;
        vector<int> dp(1 << m);
        dp[0] = 1;
        for(int i = 0; i < m; i++){
            int mask = 0;
            for(int j = 0; j < m; j++){
                if(sq[i] % (j + 1) == 0)
                    mask |= (1 << j);
            }
            for(int j = 0; j < (1 << m); j++){
                if((j & mask) == 0){
                    dp[j | (1 << i)] = (dp[j | (1 << i)] + (long long)dp[j] * cnt[i]) % mod;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < (1 << m); i++){
            int cnt = 0;
            for(int j = 0; j < m; j++){
                if((i >> j) & 1)
                    cnt++;
            }
            if(cnt % 2 == 0)
                ans = (ans + mod - dp[i]) % mod;
            else
                ans = (ans + dp[i]) % mod;
        }
        return ans;
    }
};