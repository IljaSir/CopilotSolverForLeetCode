class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long[] count = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i - 1];
            if (prefix[i] >= minK && prefix[i] <= maxK) {
                count[i]++;
            }
        }
        long result = 0;
        for (int i = 1; i <= n; i++) {
            int l = i, r = n;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (prefix[mid] - prefix[i - 1] > maxK) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            int right = l;
            l = i;
            r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (prefix[mid] - prefix[i - 1] < minK) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int left = l;
            result += count[right] - count[left - 1];
        }
        return result;
    }
}