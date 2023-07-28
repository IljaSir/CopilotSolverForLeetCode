class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] primes = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (primes[i] == 0) {
                primes[i] = i;
                for (int j = i + i; j <= max; j += i) {
                    if (primes[j] == 0) {
                        primes[j] = i;
                    }
                }
            }
        }
        int[] cnt = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    prod *= nums[j];
                }
            }
            int p = primes[prod];
            int q = prod / p;
            if (p == q) {
                cnt[i] = 1;
            } else {
                cnt[i] = cnt[i ^ (1 << (n - 1) - Integer.numberOfLeadingZeros(p))] - cnt[i ^ (1 << (n - 1) - Integer.numberOfLeadingZeros(q))];
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (cnt[i] != 0) {
                res += cnt[i] * (1 - 2 * Integer.bitCount(i) % 2);
            }
        }
        return res;
    }
}