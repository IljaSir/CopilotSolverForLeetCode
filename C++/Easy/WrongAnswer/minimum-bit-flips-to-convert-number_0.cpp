class Solution {
public:
    int minBitFlips(int start, int goal) {
        
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (start >> i) & 1;
            int b = (goal >> i) & 1;
            if (a == b) continue;
            if (a == 0) {
                ans++;
                start ^= (1 << i);
            } else {
                if (i == 31) return -1;
                ans += 2;
                start ^= (1 << i);
                start ^= (1 << (i + 1));
            }
        }
        return ans;
    }
};