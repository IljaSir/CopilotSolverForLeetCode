class Solution {
public:
    vector<int> runningSum(vector<int>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); ++i) {
            if (i == 0) {
                res.push_back(nums[i]);
            } else {
                res.push_back(res[i - 1] + nums[i]);
            }
        }
        return res;
    }
};