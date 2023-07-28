class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            int n = i;
            int nSetBits = 0;
            while (n > 0) {
                nSetBits += n & 1;
                n >>= 1;
            }
            if (nSetBits == 2 || nSetBits == 3 || nSetBits == 5 || nSetBits == 7 || nSetBits == 11 || nSetBits == 13 || nSetBits == 17 || nSetBits == 19) {
                count++;
            }
        }
        return count;
    }
};