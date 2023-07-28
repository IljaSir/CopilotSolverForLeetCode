class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int res = 0;
        int maxBit = 0;
        for (auto n : nums) {
            int bit = 0;
            while (n) {
                res += (n & 1);
                n >>= 1;
                ++bit;
            }
            maxBit = max(maxBit, bit);
        }
        return res + maxBit - 1;
    }
};