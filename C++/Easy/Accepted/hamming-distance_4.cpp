class Solution {
public:
    int hammingDistance(int x, int y) {
        
        int res = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                res++;
            }
            x >>= 1;
            y >>= 1;
        }
        return res;
    }
};