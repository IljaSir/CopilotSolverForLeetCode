class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        
        vector<vector<int>> result;
        if (nums.empty()) {
            return result;
        }
        sort(nums.begin(), nums.end());
        dfs(nums, 0, result);
        return result;
    }

    void dfs(vector<int>& nums, int start, vector<vector<int>>& result) {
        if (start == nums.size()) {
            result.push_back(nums);
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            if (i != start && nums[i] == nums[start]) {
                continue;
            }
            swap(nums[i], nums[start]);
            dfs(nums, start + 1, result);
            swap(nums[i], nums[start]);
        }
    }
};