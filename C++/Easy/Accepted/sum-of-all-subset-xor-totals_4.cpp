class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < 1 << n; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (i >> j & 1) {
                    t ^= nums[j];
                }
            }
            res += t;
        }
        return res;
    }
};