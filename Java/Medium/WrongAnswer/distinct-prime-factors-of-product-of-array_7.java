class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
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
        for (int n : nums) {
            set.add(primes[n]);
        }
        return set.size();
    }
}