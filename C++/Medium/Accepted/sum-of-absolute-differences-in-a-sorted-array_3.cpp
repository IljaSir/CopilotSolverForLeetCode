class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n + 1);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefix[i];
            int right = prefix[n] - prefix[i + 1] - nums[i] * (n - i - 1);
            ans[i] = left + right;
        }
        return ans;
    }
};