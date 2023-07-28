class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> res;
        int n = nums.size();
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix = (prefix * 2 + nums[i]) % 5;
            res.push_back(prefix == 0);
        }
        return res;
    }
};