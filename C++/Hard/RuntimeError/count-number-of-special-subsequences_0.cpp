class Solution {
public:
    int countSpecialSubsequences(vector<int>& nums) {
        
        long long a = 0, b = 0, c = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                a = 2 * a + 1;
            } else if (nums[i] == 1) {
                b = 2 * b + a;
            } else {
                c = 2 * c + b;
            }
        }
        return c % 1000000007;
    }
};