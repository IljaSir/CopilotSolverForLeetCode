class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = 0, j = nums.size() - 1;
        vector<int> ans;
        while (i < j) {
            ans.push_back(nums[i++]);
            ans.push_back(nums[j--]);
        }
        if (i == j) ans.push_back(nums[i]);
        return ans;
    }
};