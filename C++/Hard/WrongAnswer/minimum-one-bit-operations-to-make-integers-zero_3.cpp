class Solution {
public:
    int minimumOneBitOperations(int n) {
        
        int res = 0;
        int k = 0;
        while (n > 0) {
            res |= (n ^ (n >> 1)) << k;
            n >>= 1;
            k++;
        }
        return res;
    }
};