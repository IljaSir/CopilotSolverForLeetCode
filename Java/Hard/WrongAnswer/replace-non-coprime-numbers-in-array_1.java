class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int[] primes = new int[100001];
        for (int i = 2; i < 100001; i++) {
            if (primes[i] == 0) {
                for (int j = i; j < 100001; j += i) {
                    primes[j] = i;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int lcm = 1;
            while (num > 1) {
                int prime = primes[num];
                while (num % prime == 0) {
                    num /= prime;
                }
                lcm *= prime;
            }
            result.add(lcm);
        }
        return result;
    }
}