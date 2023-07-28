class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> out;
        findSubsequencesDFS(nums, 0, out, res);
        return res;
    }
    
    void findSubsequencesDFS(vector<int>& nums, int start, vector<int>& out, vector<vector<int>>& res) {
        if (out.size() >= 2) res.push_back(out);
        unordered_set<int> uset;
        for (int i = start; i < nums.size(); ++i) {
            if (uset.find(nums[i]) != uset.end()) continue;
            if (out.empty() || nums[i] >= out.back()) {
                out.push_back(nums[i]);
                findSubsequencesDFS(nums, i + 1, out, res);
                out.pop_back();
                uset.insert(nums[i]);
            }
        }
    }
};