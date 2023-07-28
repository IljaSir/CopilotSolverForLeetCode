class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[] preEven = new int[n];
        int[] preOdd = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                preEven[i] = nums[i];
                if (i > 0) {
                    preEven[i] += preEven[i - 1];
                }
            } else {
                preOdd[i] = nums[i];
                if (i > 0) {
                    preOdd[i] += preOdd[i - 1];
                }
            }
        }
        int[] sufEven = new int[n];
        int[] sufOdd = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                sufEven[i] = nums[i];
                if (i < n - 1) {
                    sufEven[i] += sufEven[i + 1];
                }
            } else {
                sufOdd[i] = nums[i];
                if (i < n - 1) {
                    sufOdd[i] += sufOdd[i + 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int even = 0;
            int odd = 0;
            if (i > 0) {
                even += preEven[i - 1];
                odd += preOdd[i - 1];
            }
            if (i < n - 1) {
                even += sufOdd[i + 1];
                odd += sufEven[i + 1];
            }
            if (even == odd) {
                ans++;
            }
        }
        return ans;
    }
}