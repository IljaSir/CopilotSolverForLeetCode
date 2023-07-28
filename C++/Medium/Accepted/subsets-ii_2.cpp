class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        sort(nums.begin(), nums.end());
        subsetsWithDupHelper(result, temp, nums, 0);
        return result;
    }
    
    void subsetsWithDupHelper(vector<vector<int>> &result, vector<int> &temp, vector<int> &nums, int start) {
        result.push_back(temp);
        for (int i = start; i < nums.size(); ++i) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.push_back(nums[i]);
            subsetsWithDupHelper(result, temp, nums, i + 1);
            temp.pop_back();
        }
    }
};