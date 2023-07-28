class Solution {
public:
    bool judgePoint24(vector<int>& cards) {
        
        vector<double> nums;
        for (auto c : cards) {
            nums.push_back(c);
        }
        return solve(nums);
    }
};