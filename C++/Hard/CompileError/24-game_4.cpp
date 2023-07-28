class Solution {
public:
    bool judgePoint24(vector<int>& cards) {
        
        vector<double> nums;
        for (auto& n : cards) {
            nums.push_back(n);
        }
        return dfs(nums);
    }
};