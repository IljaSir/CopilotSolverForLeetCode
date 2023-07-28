class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> res;
        int val = 0;
        for (int i = 0; i < nums.size(); i++) {
            val = val * 2 + nums[i];
            res.push_back(val % 5 == 0);
            val = val % 5;
        }
        return res;
    }
};