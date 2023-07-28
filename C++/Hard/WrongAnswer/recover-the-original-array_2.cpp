class Solution {
public:
    vector<int> recoverArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int k = nums[n / 2] - nums[n / 2 - 1];
        vector<int> ans(n / 2);
        for (int i = 0; i < n / 2; ++i) {
            ans[i] = nums[i] + k;
        }
        return ans;
    }
};