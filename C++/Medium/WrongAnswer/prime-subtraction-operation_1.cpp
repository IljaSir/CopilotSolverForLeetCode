class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
        vector<int> dp(n, 0);
        for (int i = 0; i < n; i++) {
            for (int p : primes) {
                if (p >= nums[i]) break;
                int j = i - 1;
                while (j >= 0 && nums[j] >= nums[i] - p) j--;
                if (j < 0 || dp[j] > 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n-1] > 0;
    }
};