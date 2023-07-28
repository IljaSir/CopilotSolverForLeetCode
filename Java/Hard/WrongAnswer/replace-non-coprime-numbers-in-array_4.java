class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] primes = new int[max + 1];
        for (int i = 2; i <= max; i++) {
            if (primes[i] == 0) {
                primes[i] = i;
                for (int j = i * 2; j <= max; j += i) {
                    if (primes[j] == 0) {
                        primes[j] = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num == 1) {
                result.add(1);
                continue;
            }
            int d = num;
            int p = primes[d];
            while (d > 1) {
                d /= primes[d];
                if (p != primes[d]) {
                    result.add(num);
                    break;
                }
            }
        }
        return result;
    }
}