class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        vector<vector<int>> ret;
        vector<int> tmp;
        dfs(ret, tmp, 0, nums);
        return ret;
    }
    void dfs(vector<vector<int>>& ret, vector<int>& tmp, int idx, vector<int>& nums) {
        if (idx == nums.size()) {
            ret.push_back(tmp);
            return;
        }
        int cnt = 1;
        while (idx + cnt < nums.size() && nums[idx + cnt] == nums[idx]) {
            ++cnt;
        }
        dfs(ret, tmp, idx + cnt, nums);
        for (int i = 0; i < cnt; ++i) {
            tmp.push_back(nums[idx]);
            dfs(ret, tmp, idx + cnt, nums);
        }
        for (int i = 0; i < cnt; ++i) {
            tmp.pop_back();
        }
    }
};