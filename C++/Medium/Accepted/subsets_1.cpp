class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> path;
        dfs(nums, 0, path, res);
        return res;
    }
    void dfs(vector<int>& nums, int index, vector<int>& path, vector<vector<int>>& res) {
        if (index == nums.size()) {
            res.push_back(path);
            return;
        }
        dfs(nums, index + 1, path, res);
        path.push_back(nums[index]);
        dfs(nums, index + 1, path, res);
        path.pop_back();
    }
};