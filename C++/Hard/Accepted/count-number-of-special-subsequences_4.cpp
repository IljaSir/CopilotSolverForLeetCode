class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        long long int dp[3] = {0};
        for(int i = 0; i < nums.size(); i++){
            if(nums[i] == 0){
                dp[0] = (dp[0] * 2) % 1000000007 + 1;
            }else if(nums[i] == 1){
                dp[1] = (dp[1] * 2 + dp[0]) % 1000000007;
            }else{
                dp[2] = (dp[2] * 2 + dp[1]) % 1000000007;
            }
        }
        return dp[2];
    }
};