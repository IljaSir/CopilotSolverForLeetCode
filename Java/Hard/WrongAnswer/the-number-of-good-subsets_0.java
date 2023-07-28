class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int[] count = new int[32];
        int mod = 1000000007;
        for (int num : nums) {
            count[num]++;
        }
        long res = 1;
        for (int prime : primes) {
            long max = 0;
            for (int i = prime; i < 32; i += prime) {
                max += count[i];
            }
            long temp = 1;
            for (int i = 0; i < max; i++) {
                temp = (temp * prime) % mod;
            }
            res = (res * temp) % mod;
        }
        long all = 0;
        for (int i = 1; i < 32; i++) {
            all += count[i];
        }
        long temp = 1;
        for (int i = 0; i < all; i++) {
            temp = (temp * 2) % mod;
        }
        res = (res * (temp - 1)) % mod;
        return (int) res;
    }
}