class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        int[] primes = {2,3,5,7,11,13,17,19};
        int count = 0;
        for (int i = left; i <= right; i++) {
            int bits = 0;
            int n = i;
            while (n > 0) {
                bits += n & 1;
                n >>= 1;
            }
            for (int p : primes) {
                if (bits == p) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}