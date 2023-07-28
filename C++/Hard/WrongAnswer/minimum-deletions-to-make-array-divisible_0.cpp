class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size(), m = numsDivide.size();
        int gcd = numsDivide[0];
        for (int i = 1; i < m; ++i) {
            gcd = __gcd(gcd, numsDivide[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] % gcd != 0) {
                nums.erase(nums.begin() + i);
                --i;
                --n;
            }
        }
        if (n == 0) {
            return -1;
        }
        sort(nums.begin(), nums.end());
        int result = 0;
        for (int i = 0; i < m; ++i) {
            result += numsDivide[i] / gcd - 1;
        }
        return result;
    }
};