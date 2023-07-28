class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        
        vector<vector<int>> ans;
        vector<int> path;
        vector<int> used(nums.size(), 0);
        sort(nums.begin(), nums.end());
        backtrack(nums, ans, path, used);
        return ans;
    }
    void backtrack(vector<int>& nums, vector<vector<int>>& ans, vector<int>& path, vector<int>& used) {
        if (path.size() == nums.size()) {
            ans.push_back(path);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0)) {
                continue;
            }
            path.push_back(nums[i]);
            used[i] = 1;
            backtrack(nums, ans, path, used);
            used[i] = 0;
            path.pop_back();
        }
    }
};