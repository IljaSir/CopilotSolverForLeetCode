class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> ans(n);
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i / 2 + n / 2 * (i % 2)];
        }
        return ans;
    }
};