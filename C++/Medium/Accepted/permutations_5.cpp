class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        
        vector<vector<int>> ans;
        vector<int> v;
        permute(nums, ans, v);
        return ans;
    }
    
    void permute(vector<int>& nums, vector<vector<int>>& ans, vector<int>& v) {
        if (nums.empty()) {
            ans.push_back(v);
            return;
        }
        for (int i = 0; i < nums.size(); ++i) {
            v.push_back(nums[i]);
            int temp = nums[i];
            nums.erase(nums.begin() + i);
            permute(nums, ans, v);
            nums.insert(nums.begin() + i, temp);
            v.pop_back();
        }
    }
};