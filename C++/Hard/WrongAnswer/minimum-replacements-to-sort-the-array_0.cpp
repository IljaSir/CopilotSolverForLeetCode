class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        
        long long res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] & 1) {
                if (i + 1 < nums.size() && nums[i + 1] & 1) {
                    ++i;
                }
                ++res;
            }
        }
        return res;
    }
};