class Solution {
public:
    int binaryGap(int n) {
        
        int max = 0;
        int prev = -1;
        int curr = 0;
        while (n > 0) {
            if (n & 1) {
                if (prev > -1) {
                    curr = curr - prev;
                    if (curr > max) {
                        max = curr;
                    }
                }
                prev = curr;
            }
            curr++;
            n >>= 1;
        }
        return max;
    }
};