class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        vector<int> prime(n+1, 1);
        for(int i=2; i<=n; i++){
            if(prime[i]){
                for(int j=2*i; j<=n; j+=i){
                    prime[j] = 0;
                }
            }
        }
        vector<int> dp(n+1, 1);
        for(int i=2; i<=n; i++){
            if(prime[i]){
                for(int j=i; j<=n; j+=i){
                    dp[j] = i;
                }
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] > 1 && dp[nums[i]] != nums[i]){
                int j = i+1;
                while(j < n && nums[j] > 1 && dp[nums[j]] != nums[j]){
                    j++;
                }
                res.push_back(dp[nums[i]] * dp[nums[j]]);
                i = j;
            }else{
                res.push_back(nums[i]);
            }
        }
        return res;
    }
};