class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int min = i + 1, max = n - 1;
            while (min < max) {
                int mid = (min + max) / 2;
                if (prefix[mid] - prefix[i] < prefix[i]) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            int l = min;
            min = i + 1;
            max = n - 1;
            while (min < max) {
                int mid = (min + max + 1) / 2;
                if (prefix[n - 1] - prefix[mid] >= prefix[mid] - prefix[i]) {
                    min = mid;
                } else {
                    max = mid - 1;
                }
            }
            int r = min;
            if (l <= r) {
                ans = (ans + r - l + 1) % 1000000007;
            }
        }
        return ans;
    }
}