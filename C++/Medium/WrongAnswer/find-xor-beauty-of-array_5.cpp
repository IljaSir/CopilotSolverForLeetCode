class Solution {
public:
    int xorBeauty(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for (int j = 0; j < n; j++) {
                if ((nums[j] >> i) & 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            res += (1 << i) * ones * zeros;
        }
        return res;
    }
};