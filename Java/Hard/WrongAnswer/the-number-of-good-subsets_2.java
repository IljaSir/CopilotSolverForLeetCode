class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int[] cnt = new int[primes.length];
        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < primes.length; j++) {
                if (nums[i] % primes[j] == 0) {
                    cnt[j]++;
                }
            }
        }
        long res = 1;
        for (int i = 0; i < primes.length; i++) {
            res = res * (cnt[i] + 1) % mod;
        }
        return (int) res;
    }
}