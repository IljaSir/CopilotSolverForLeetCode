class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> result;
        vector<int> temp;
        vector<int> used(nums.size(), 0);
        permute(nums, temp, result, used);
        return result;
    }
    
    void permute(vector<int>& nums, vector<int>& temp, vector<vector<int>>& result, vector<int>& used) {
        if (temp.size() == nums.size()) {
            result.push_back(temp);
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (used[i] == 0) {
                used[i] = 1;
                temp.push_back(nums[i]);
                permute(nums, temp, result, used);
                used[i] = 0;
                temp.pop_back();
            }
        }
    }
};