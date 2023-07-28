class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int n = nums.length;
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (prime[i]) {
                for (int j = 2; i * j < 1001; j++) {
                    prime[i * j] = false;
                }
            }
        }
        int[] diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 1; i < n; i++) {
            if (diff[i] <= 0) {
                boolean flag = false;
                for (int j = 2; j < nums[i]; j++) {
                    if (prime[j] && nums[i] - j > diff[i - 1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
    }
}