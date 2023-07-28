class Solution {
    public int distinctPrimeFactors(int[] nums) {
        
        int[] prime = new int[1001];
        for (int i = 2; i <= 1000; i++) {
            if (prime[i] == 0) {
                for (int j = i; j <= 1000; j += i) {
                    prime[j]++;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(prime[num]);
        }
        return set
                }
            }
            if (n > 1) {
                set.add(n);
            }
        }
        return set.size();
    }
}