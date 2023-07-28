class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        
        vector<vector<int>> res;
        vector<int> tmp;
        dfs(nums, 0, tmp, res);
        return res;
    }
    void dfs(vector<int>& nums, int index, vector<int>& tmp, vector<vector<int>>& res){
        if(index == nums.size()){
            res.push_back(tmp);
            return;
        }
        tmp.push_back(nums[index]);
        dfs(nums, index+1, tmp, res);
        tmp.pop_back();
        dfs(nums, index+1, tmp, res);
    }
};