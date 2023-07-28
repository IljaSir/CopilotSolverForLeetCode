class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int[] primes = new int[100001];
        for (int i = 2; i <= 100000; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= 100000; j += i) {
                    primes[j] = i;
                }
            }
        }
        int n = nums.length;
        int[] lcms = new int[n];
        int[] rcms = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num > 1) {
                int p = primes[num];
                while (num % p == 0) {
                    num /= p;
                }
                if (lcms[i] == 0) {
                    lcms[i] = p;
                } else {
                    lcms[i] = lcm(lcms[i], p);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (num > 1) {
                int p = primes[num];
                while (num % p == 0) {
                    num /= p;
                }
                if (rcms[i] == 0) {
                    rcms[i] = p;
                } else {
                    rcms[i] = lcm(rcms[i], p);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && lcms[i - 1] == rcms[i]) {
                ans.add(lcms[i - 1]);
                i++;
            } else {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    
    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}