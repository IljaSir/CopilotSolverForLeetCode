class Solution {
public:
    int xorBeauty(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int n : nums) {
                if (n & (1 << i)) ++cnt;
            }
            res |= (cnt % 2) << i;
        }
        return res;
    }
};