class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int[] primes = new int[100001];
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                for (int j = i; j < primes.length; j += i) {
                    if (primes[j] == 0) {
                        primes[j] = i;
                    }
                }
            }
        }
        int[] lcm = new int[100001];
        for (int i = 2; i < lcm.length; i++) {
            if (lcm[i] == 0) {
                for (int j = i; j < lcm.length; j += i) {
                    if (lcm[j] == 0) {
                        lcm[j] = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length - 1 && nums[i] != nums[i - 1] && nums[i] != nums[i + 1] && primes[nums[i]] != nums[i] && primes[nums[i - 1]] != nums[i - 1] && primes[nums[i + 1]] != nums[i + 1]) {
                int lcmNumber = lcm[nums[i - 1]] * lcm[nums[i + 1]];
                lcmNumber = lcmNumber / gcd(lcmNumber, nums[i - 1]);
                lcmNumber = lcmNumber / gcd(lcmNumber, nums[i + 1]);
                result.add(lcmNumber);
                i++;
            } else {
                result.add(nums[i]);
            }
        }
        return result;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}