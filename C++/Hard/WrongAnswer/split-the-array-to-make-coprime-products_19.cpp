class Solution {
public:
    int findValidSplit(vector<int>& nums) {
        
        int n = nums.size();
        int left = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = gcd(right, nums[i]);
            if (right == 1) {
                return i;
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            left = gcd(left, nums[i]);
            right = gcd(right, nums[i]);
            if (left == 1 && right == 1) {
                return i;
            }
        }
        return -1;
    }
};