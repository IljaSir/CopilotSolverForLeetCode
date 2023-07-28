class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i] - target[i];
        }
        return sum;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        long long sum = makeSimilar(nums, target);
        if (sum == 0) return 0;
        int n = nums.size();
        vector<int> nums1, target1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > target[i]) {
                nums1.push_back(nums[i]);
                target1.push_back(target[i]);
            }
        }
        int m = nums1.size();
        vector<int> dp(1 << m, 0);
        for (int i = 0; i < (1 << m); i++) {
            long long sum1 = 0;
            for (int j = 0; j < m; j++) {
                if (i & (1 << j)) {
                    sum1 += nums1[j] - target1[j];
                }
            }
            if (sum1 == sum) return __builtin_popcount(i);
            for (int j = 0; j < m; j++) {
                if (i & (1 << j)) continue;
                dp[i | (1 << j)] = max(dp[i | (1 << j)], dp[i] + 1);
            }
        }
        return -1;
    }
};