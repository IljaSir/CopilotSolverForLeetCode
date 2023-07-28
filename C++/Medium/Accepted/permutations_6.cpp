class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        vector<bool> used(nums.size(), false);
        dfs(nums, used, temp, result);
        return result;
    }

    void dfs(vector<int>& nums, vector<bool>& used, vector<int>& temp, vector<vector<int>>& result) {
        if (temp.size() == nums.size()) {
            result.push_back(temp);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.push_back(nums[i]);
            dfs(nums, used, temp, result);
            temp.pop_back();
            used[i] = false;
        }
    }
};