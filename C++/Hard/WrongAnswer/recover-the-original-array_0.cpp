class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size() / 2;
        sort(nums.begin(), nums.end());
        vector<int> ans(n);
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[i] + nums[n + i];
            ans[i] /= 2;
        }
        return ans;
    }
};