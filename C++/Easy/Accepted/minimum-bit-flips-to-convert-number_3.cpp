class Solution {
public:
    int minBitFlips(int start, int goal) {
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int s = start & 1;
            int g = goal & 1;
            if (s != g) {
                count++;
            }
            start >>= 1;
            goal >>= 1;
        }
        return count;
    }
};