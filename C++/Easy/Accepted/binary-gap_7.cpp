class Solution {
public:
    int binaryGap(int n) {
        
        int maxGap = 0;
        int currentGap = 0;
        bool foundOne = false;
        while (n != 0) {
            if (n & 1) {
                if (foundOne) {
                    if (currentGap > maxGap) {
                        maxGap = currentGap;
                    }
                } else {
                    foundOne = true;
                }
                currentGap = 1;
            } else {
                if (foundOne) {
                    currentGap++;
                }
            }
            n = n >> 1;
        }
        return maxGap;
    }
};