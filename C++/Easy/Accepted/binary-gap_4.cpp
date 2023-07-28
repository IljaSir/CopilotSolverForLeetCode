class Solution {
public:
    int binaryGap(int n) {
        
        int last = -1, max = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & (1 << i)) != 0) {
                if (last != -1) {
                    max = std::max(max, i - last);
                }
                last = i;
            }
        }
        return max;
    }
};