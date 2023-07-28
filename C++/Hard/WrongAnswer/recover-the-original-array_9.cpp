class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size() / 2;
        vector<int> ans(n);
        sort(nums.begin(), nums.end());
        int diff = nums[n] - nums[n-1];
        ans[0] = (nums[n-1] + nums[n]) / 2;
        for (int i = 1; i < n; ++i) {
            ans[i] = ans[i-1] + diff;
        }
        return ans;
    }
};