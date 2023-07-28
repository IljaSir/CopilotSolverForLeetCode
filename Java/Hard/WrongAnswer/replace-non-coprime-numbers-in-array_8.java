class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int[] primes = new int[100001];
        int[] factors = new int[100001];
        for (int i = 2; i <= 100000; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= 100000; j += i) {
                    if (primes[j] == 0) {
                        primes[j] = i;
                    }
                }
            }
        }
        for (int i = 2; i <= 100000; i++) {
            int j = i;
            while (j > 1) {
                int p = primes[j];
                while (j % p == 0) {
                    j /= p;
                }
                factors[i] = p;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (factors[num] == num) {
                res.add(num);
            } else {
                res.add(factors[num]);
                while (i + 1 < n && factors[nums[i + 1]] != nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}