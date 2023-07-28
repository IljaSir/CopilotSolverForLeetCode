class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> current;
        sort(nums.begin(), nums.end());
        dfs(nums, 0, current, result);
        return result;
    }
    
    void dfs(vector<int>& nums, int index, vector<int>& current, vector<vector<int>>& result) {
        result.push_back(current);
        for (int i = index; i < nums.size(); ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.push_back(nums[i]);
            dfs(nums, i + 1, current, result);
            current.pop_back();
        }
    }
};