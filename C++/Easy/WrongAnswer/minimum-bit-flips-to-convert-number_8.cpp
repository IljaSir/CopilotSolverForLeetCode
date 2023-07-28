class Solution {
public:
    int minBitFlips(int start, int goal) {
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((start ^ goal) & 1) {
                if (start & 1) {
                    res++;
                } else {
                    return -1;
                }
            }
            start >>= 1;
            goal >>= 1;
        }
        return res;
    }
};