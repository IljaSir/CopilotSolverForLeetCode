class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        
        int res = original;
        for (auto n : nums) {
            if (n == res) {
                res *= 2;
            }
        }
        return res;
    }
};