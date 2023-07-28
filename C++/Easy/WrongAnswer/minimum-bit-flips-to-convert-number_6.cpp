class Solution {
public:
    int minBitFlips(int start, int goal) {
        
        int ans = 0;
        for (int i = 30; i >= 0; --i) {
            if ((start >> i & 1) != (goal >> i & 1)) {
                if (i == 0) {
                    return -1;
                }
                ans++;
                start ^= 1 << i;
                start ^= 1 << (i - 1);
            }
        }
        return ans;
    }
};