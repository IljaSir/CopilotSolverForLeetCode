class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> prefix(n);
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            int left = i * nums[i] - (i > 0 ? prefix[i - 1] : 0);
            int right = (prefix[n - 1] - prefix[i]) - (n - i - 1) * nums[i];
            ans[i] = left + right;
        }
        return ans;
    }
};