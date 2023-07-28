class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        long long result = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] % 2 == 0) {
                continue;
            }
            if (i < nums.size() - 1 && nums[i + 1] % 2 == 0) {
                ++i;
            }
            ++result;
        }
        return result;
    }
};