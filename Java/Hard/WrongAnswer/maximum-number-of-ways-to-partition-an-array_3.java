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
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (prefix[i - 1] == suffix[i]) {
                count++;
            }
        }
        int max = count;
        for (int i = 0; i < n; i++) {
            int sum = prefix[i] - nums[i] + k;
            int j = i + 1;
            while (j < n && prefix[j - 1] < sum) {
                j++;
            }
            if (j < n && prefix[j - 1] == sum) {
                int cnt = count;
                if (j < n && prefix[j - 1] == suffix[j]) {
                    cnt--;
                }
                if (i > 0 && prefix[i - 1] == suffix[i]) {
                    cnt--;
                }
                max = Math.max(max, cnt + 1);
            }
        }
        return max;
    }
}