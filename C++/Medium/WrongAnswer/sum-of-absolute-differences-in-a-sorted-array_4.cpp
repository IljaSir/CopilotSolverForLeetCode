class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, 0);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            ans[0] += nums[i] - nums[0];
            sum += nums[i];
        }
        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i - 1] + (nums[i] - nums[i - 1]) * i - (sum - nums[i] * n);
        }
        return ans;
    }
};