class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> result;
        int num = 0;
        for (int i = 0; i < nums.size(); i++) {
            num = num * 2 + nums[i];
            num = num % 5;
            result.push_back(num == 0);
        }
        return result;
    }
};