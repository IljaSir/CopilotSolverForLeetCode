class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        
        vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        vector<int> tmp;
        vector<vector<int>> res;
        dfs(nums, k, n, 0, tmp, res);
        return res;
    }
    void dfs(vector<int> &nums, int k, int n, int start, vector<int> &tmp, vector<vector<int>> &res) {
        if (n == 0 && tmp.size() == k) {
            res.push_back(tmp);
            return;
        }
        for (int i = start; i < nums.size(); i++) {
            if (n - nums[i] < 0) return;
            tmp.push_back(nums[i]);
            dfs(nums, k, n - nums[i], i + 1, tmp, res);
            tmp.pop_back();
        }
    }
};