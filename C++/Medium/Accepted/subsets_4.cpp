class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> subset;
        subsets(nums, 0, subset, result);
        return result;
    }
    
    void subsets(vector<int>& nums, int start, vector<int>& subset, vector<vector<int>>& result) {
        result.push_back(subset);
        for (int i = start; i < nums.size(); i++) {
            subset.push_back(nums[i]);
            subsets(nums, i + 1, subset, result);
            subset.pop_back();
        }
    }
};