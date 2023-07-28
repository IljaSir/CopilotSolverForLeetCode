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
            if (prefix[i] * 3 > prefix[n - 1]) {
                break;
            }
            int left = i + 1, right = n - 2;
            int target = prefix[i] * 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (prefix[left] < target) {
                continue;
            }
            int min = left;
            left = i + 1;
            right = n - 2;
            target = prefix[n - 1] - prefix[i];
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (prefix[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (prefix[left] > target) {
                continue;
            }
            int max = left;
            ans = (ans + max - min + 1) % 1000000007;
        }
        return ans;
    }
}