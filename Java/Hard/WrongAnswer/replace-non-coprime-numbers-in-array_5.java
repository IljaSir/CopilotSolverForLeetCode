class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int[] sieve = new int[100001];
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i] == 0) {
                sieve[i] = i;
                for (int j = 2 * i; j < sieve.length; j += i) {
                    if (sieve[j] == 0) {
                        sieve[j] = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            if (n == 1) {
                res.add(1);
            } else {
                int p = sieve[n];
                int m = n;
                while (m % p == 0) {
                    m /= p;
                }
                if (m == 1) {
                    res.add(n);
                } else {
                    res.add(p * m);
                }
            }
        }
        return res;
    }
}