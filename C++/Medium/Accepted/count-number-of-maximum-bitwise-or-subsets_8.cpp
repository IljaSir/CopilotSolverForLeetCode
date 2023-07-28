class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        int cnt = 0;
        vector<int> dp(1 << n, 0);
        for (int i = 1; i < (1 << n); i++) {
            int x = i & -i;
            int j = 0;
            while (x) {
                x >>= 1;
                j++;
            }
            dp[i] = dp[i ^ (1 << (j - 1))] | nums[j - 1];
            if (dp[i] > max) {
                max = dp[i];
                cnt = 1;
            } else if (dp[i] == max) {
                cnt++;
            }
        }
        return cnt;
    }
};