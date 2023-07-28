class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            int tmp = i;
            int bitCount = 0;
            while (tmp) {
                bitCount += tmp & 1;
                tmp >>= 1;
            }
            if (isPrime(bitCount)) count++;
        }
        return count;
    }
};