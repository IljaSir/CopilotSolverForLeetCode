class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int[] primes = new int[100001];
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                primes[i] = i;
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = i;
                }
            }
        }
        int[] maxPrime = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (n > 1) {
                int prime = primes[n];
                maxPrime[prime] = Math.max(maxPrime[prime], nums[i]);
                while (n % prime == 0) {
                    n /= prime;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            boolean found = false;
            while (n > 1) {
                int prime = primes[n];
                if (maxPrime[prime] > nums[i]) {
                    result.add(maxPrime[prime]);
                    found = true;
                    break;
                }
                while (n % prime == 0) {
                    n /= prime;
                }
            }
            if (!found) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}