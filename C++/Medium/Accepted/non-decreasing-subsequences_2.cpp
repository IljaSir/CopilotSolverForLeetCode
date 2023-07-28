class Solution {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> out;
        dfs(res, out, nums, 0);
        return res;
    }
    
    void dfs(vector<vector<int>>& res, vector<int>& out, vector<int>& nums, int start){
        if(out.size() >= 2){
            res.push_back(out);
        }
        unordered_set<int> used;
        for(int i = start; i < nums.size(); ++i){
            if(used.count(nums[i])) continue;
            if(out.empty() || nums[i] >= out.back()){
                used.insert(nums[i]);
                out.push_back(nums[i]);
                dfs(res, out, nums, i + 1);
                out.pop_back();
            }
        }
    }
};