class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        dfs(nums, 0, temp, result);
        return result;
    }
    void dfs(vector<int>& nums, int start, vector<int>& temp, vector<vector<int>>& result) {
        if (temp.size() >= 2) {
            result.push_back(temp);
        }
        unordered_set<int> s;
        for (int i = start; i < nums.size(); ++i) {
            if (s.count(nums[i])) {
                continue;
            }
            if (temp.empty() || nums[i] >= temp.back()) {
                s.insert(nums[i]);
                temp.push_back(nums[i]);
                dfs(nums, i + 1, temp, result);
                temp.pop_back();
            }
        }
    }
};