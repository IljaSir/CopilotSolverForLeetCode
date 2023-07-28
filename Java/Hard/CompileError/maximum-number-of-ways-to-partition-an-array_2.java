class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[n - i - 1] = suffix[n - i] + nums[n - i - 1];
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                left[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (left[i + 1] == 1) {
                left[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                right[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (right[i - 1] == 1) {
                right[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] == 1) {
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                ans = Math.max(ans, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                ans = Math.max(ans, 1 + right[i + 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                ans = Math.max(ans, 1 + left[i - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                int sum = prefix[i];
    }
}