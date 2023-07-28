class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < 1001; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= prev) {
                return false;
            }
            for (int j = nums[i] - 1; j > 0; j--) {
                if (isPrime[j] && nums[i] - j > prev) {
                    nums[i] -= j;
                    break;
                }
            }
            prev = nums[i];
        }
        return true;
    }
}
    }
}