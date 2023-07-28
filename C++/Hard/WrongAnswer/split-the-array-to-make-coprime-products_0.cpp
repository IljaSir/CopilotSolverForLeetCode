class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        int g = nums[0];
        for (int i = 1; i < n; ++i) {
            g = gcd(g, nums[i]);
        }
        if (g != 1) {
            return -1;
        }
        int left = nums[0];
        for (int i = 1; i < n; ++i) {
            if (gcd(left, nums[i]) == 1) {
                return i - 1;
            }
            left *= nums[i];
        }
        return n - 2;
    }
};