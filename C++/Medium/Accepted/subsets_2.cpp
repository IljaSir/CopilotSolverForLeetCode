class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        backtrack(result, temp, nums, 0);
        return result;
    }
    
    void backtrack(vector<vector<int>>& result, vector<int>& temp, vector<int>& nums, int start)
    {
        result.push_back(temp);
        for(int i = start; i < nums.size(); i++)
        {
            temp.push_back(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.pop_back();
        }
    }
};