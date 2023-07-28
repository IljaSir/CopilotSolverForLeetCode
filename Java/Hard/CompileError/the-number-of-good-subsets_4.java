class Solution {
    public int numberOfGoodSubsets(int[] nums) {
        
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int[] counts = new int[32];
        for (int num : nums) {
            counts[num]++;
        }
        int[] f = new int[1 << 11];
        f[0] = 1;
        for (int i = 0; i < 32; i++) {
            if (counts[i] == 0) {
                continue;
            }
            int mask = 0;
            for (int j = 0; j < 11; j++) {
                if (i % primes[j] == 0) {
                    mask |= 1 << j;
                }
            }
            for (int j = (1 << 11) - 1; j >= 0; j--) {
                int nj = j | mask;
                f[nj] += f[j] * counts[i];
                f[nj] %= 1000000007;
            }
        }
        int ans = 0;
        for (int i = 0; i < 1 << 11; i++) {
            int cnt = Integer.bitCount(i);
            if (cnt % 2 == 1) {;
        }
        return ans
    }
}