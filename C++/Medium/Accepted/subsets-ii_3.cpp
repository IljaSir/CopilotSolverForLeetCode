class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        sort(nums.begin(), nums.end());
        backtrack(nums, temp, result, 0);
        return result;
    }
    
    void backtrack(vector<int>& nums, vector<int>& temp, vector<vector<int>>& result, int index) {
        result.push_back(temp);
        for (int i = index; i < nums.size(); i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            temp.push_back(nums[i]);
            backtrack(nums, temp, result, i + 1);
            temp.pop_back();
        }
    }
};