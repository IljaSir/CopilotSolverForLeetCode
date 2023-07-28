class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] primes = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    primes[j]++;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int n = num;
            for (int i = 2; i <= max; i++) {
                if (n % i == 0 && primes[i] == 1) {
                    set.add(i);
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
            if (n > 1) {
                set.add(n);
            }
        }
        return set.size();
    }
}