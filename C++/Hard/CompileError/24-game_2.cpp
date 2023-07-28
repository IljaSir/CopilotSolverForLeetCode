class Solution {
public:
    bool judgePoint24(vector<int>& cards) {
        
        vector<double> nums;
        for (int card : cards) {
            nums.push_back(card);
        }
        return solve(nums);
    }
};