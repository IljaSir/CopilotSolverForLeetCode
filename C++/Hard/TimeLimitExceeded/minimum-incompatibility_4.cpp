class Solution {
public:
    int minimumIncompatibility(vector<int>& nums, int k) {
        
        int n = nums.size();
        int m = n/k;
        sort(nums.begin(), nums.end());
        vector<int> dp(1<<n, 1e9);
        dp[0] = 0;
        for(int i=0; i<(1<<n); i++){
            int cnt = 0, x = i;
            while(x){
                cnt += x&1;
                x >>= 1;
            }
            if(cnt%m != 0) continue;
            int l = 0, r = 0;
            while(l < n){
                while(r < n && (i&(1<<r)) == 0) r++;
                if(r == n) break;
                int tmp = i;
                for(int j=l; j<r; j++) tmp ^= (1<<j);
                dp[i] = min(dp[i], dp[tmp]);
                l = r;
            }
            if(dp[i] == 1e9) continue;
            bool flag = true;
            for(int j=0; j<n; j++){
                if((i&(1<<j)) && (j>0 && (i&(1<<(j-1))) && nums[j-1] == nums[j])){
                    flag = false;
                    break;
                }
            }
            if(!flag) continue;
            int cur = 0;
            for(int j=0; j<m; j++){
                cur += nums[i*__builtin_popcount(i) + j] - nums[i*__builtin_popcount(i)];
            }
            dp[i] += cur;
        }
        return dp[(1<<n)-1] == 1e9 ? -1 : dp[(1<<n)-1];
    }
};