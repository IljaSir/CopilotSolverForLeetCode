class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        vector<int> ans(n, 0);
        for (int i = 0; i < n; i++) {
            ans[i] = (nums[i] * i - sum[i]) + (sum[n] - sum[i+1] - nums[i]*(n-i-1));
        }
        return ans;
    }
};