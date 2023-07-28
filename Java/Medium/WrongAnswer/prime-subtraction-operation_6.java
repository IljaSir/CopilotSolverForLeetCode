class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int[] primes = new int[1001];
        Arrays.fill(primes, 1);
        for (int i = 2; i < 1001; i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j < 1001; j += i) {
                    primes[j] = 0;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            while (n > 1) {
                if (primes[n] == 1) {
                    nums[i] -= n;
                    break;
                }
                n--;
            }
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}