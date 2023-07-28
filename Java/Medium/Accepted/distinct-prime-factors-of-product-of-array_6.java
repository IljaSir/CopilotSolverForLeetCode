class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] primes = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    primes[j] = i;
                }
            }
        }
        Set<Integer> factors = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 1) {
                factors.add(primes[num]);
                num /= primes[num];
            }
        }
        return factors.size();
    }
}