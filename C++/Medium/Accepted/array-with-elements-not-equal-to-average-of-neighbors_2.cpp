class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        vector<int> ans(n);
        int l = 0, r = n - 1;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                ans[i] = nums[l++];
            } else {
                ans[i] = nums[r--];
            }
        }
        return ans;
    }
};