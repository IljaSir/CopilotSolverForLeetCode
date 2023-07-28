class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        int n = nums.length;
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < 1001; i++) {
            if (prime[i]) {
                for (int j = 2; i * j < 1001; j++) {
                    prime[i * j] = false;
                }
            }
        }
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(nums[i], pre[i - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pre[i]) {
                boolean flag = false;
                for (int j = 2; j < nums[i]; j++) {
                    if (prime[j] && nums[i] - j >= pre[i]) {
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