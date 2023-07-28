class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> result;
        permute(nums, 0, result);
        return result;
    }
    
    void permute(vector<int>& nums, int i, vector<vector<int>>& result) {
        if (i == nums.size()) {
            result.push_back(nums);
            return;
        }
        
        for (int j = i; j < nums.size(); ++j) {
            swap(nums[i], nums[j]);
            permute(nums, i + 1, result);
            swap(nums[i], nums[j]);
        }
    }
};