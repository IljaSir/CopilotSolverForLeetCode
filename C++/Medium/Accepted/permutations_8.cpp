class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> res;
        int n = nums.size();
        vector<int> tmp;
        vector<bool> flag(n, false);
        dfs(res, tmp, flag, nums);
        return res;
    }
    void dfs(vector<vector<int>>& res, vector<int>& tmp, vector<bool>& flag, vector<int>& nums){
        if(tmp.size() == nums.size()){
            res.push_back(tmp);
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if(flag[i]) continue;
            flag[i] = true;
            tmp.push_back(nums[i]);
            dfs(res, tmp, flag, nums);
            tmp.pop_back();
            flag[i] = false;
        }
    }
};