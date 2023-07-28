class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            suffix[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) {
                res++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                continue;
            }
            int diff = k - nums[i];
            nums[i] = k;
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += nums[j];
                prefix[j] = sum;
            }
            sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                sum += nums[j];
                suffix[j] = sum;
            }
            for (int j = 0; j < n; j++) {
                if (prefix[j] == suffix[j]) {
                    res++;
                }
            }
            nums[i] = k - diff;
        }
        return res;
    }
}