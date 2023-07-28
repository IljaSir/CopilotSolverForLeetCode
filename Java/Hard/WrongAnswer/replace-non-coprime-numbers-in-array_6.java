class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int n = nums.length;
        int[] primes = new int[100001];
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 0) {
                for (int j = i; j < primes.length; j += i) {
                    primes[j] = i;
                }
            }
        }
        int[] lcm = new int[100001];
        for (int i = 2; i < lcm.length; i++) {
            if (lcm[i] == 0) {
                int p = primes[i];
                for (int j = i; j < lcm.length; j += p) {
                    lcm[j] = i;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : nums) {
            ans.add(lcm[x]);
        }
        return ans;
    }
}