class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                int left = prefix[i];
                int right = prefix[n - 1] - prefix[mid - 1];
                int midSum = prefix[mid - 1] - prefix[i];
                if (left <= midSum && midSum <= right) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int left = prefix[i];
            int right = prefix[n - 1] - prefix[r - 1];
            int midSum = prefix[r - 1] - prefix[i];
            if (left <= midSum && midSum <= right) {
                res = (res + r - i) % 1000000007;
            }
        }
        return res;
    }
}