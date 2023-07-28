class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        
        vector<bool> result;
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum = (sum << 1) + nums[i];
            sum = sum % 5;
            result.push_back(sum == 0);
        }
        return result;
    }
};