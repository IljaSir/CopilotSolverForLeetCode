class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> result;
        int i = 0;
        int x = 0;
        for (i = 0; i < nums.size(); i++) {
            x = (x << 1) | nums[i];
            x = x % 5;
            result.push_back(x == 0);
        }
        return result;
    }
};