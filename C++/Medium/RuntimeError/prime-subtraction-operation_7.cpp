class Solution {
public:
    bool primeSubOperation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prime(1001, 0);
        prime[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            if (prime[i] == 0) {
                for (int j = i * 2; j <= 1000; j += i) {
                    prime[j] = 1;
                }
            }
        }
        vector<int> dp(n, 0);
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == 1) {
                return true;
            }
            for (int j = 2; j < dp[i]; j++) {
                if (prime[j] == 0 && dp[i] % j == 0) {
                    int k = 0;
                    while (k < n && nums[k] != dp[i]) {
                        k++;
                    }
                    nums[k] -= j;
                    return primeSubOperation(nums);
                }
            }
        }
        return false;
    }
};