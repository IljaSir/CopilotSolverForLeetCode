class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = 0;
            int n = i;
            while (n > 0) {
                bits += n % 2;
                n /= 2;
            }
            if (bits == 2 || bits == 3 || bits == 5 || bits == 7 || bits == 11 || bits == 13 || bits == 17 || bits == 19) {
                count++;
            }
        }
        return count;
    }
};