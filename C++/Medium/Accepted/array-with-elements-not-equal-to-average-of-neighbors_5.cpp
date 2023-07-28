class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<int> ans(nums.size());
        for (int i = 0, j = 0, k = nums.size() - 1; i < nums.size(); i += 2, j++, k--)
        {
            ans[i] = nums[j];
            if (i + 1 < nums.size()) ans[i + 1] = nums[k];
        }
        return ans;
    }
};