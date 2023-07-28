class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << n/2];
        int[] right = new int[1 << (n - n/2)];
        for (int i = 0; i < 1 << n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                if ((i & (1 << j)) != 0) {
                    left[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < 1 << (n - n/2); i++) {
            for (int j = 0; j < n - n/2; j++) {
                if ((i & (1 << j)) != 0) {
                    right[i] += nums[n/2 + j];
                }
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int ans = Math.abs(goal);
        for (int i = 0; i < 1 << (n - n/2); i++) {
            int l = 0, r = 1 << n/2;
            while (l < r) {
                int mid = l + r >> 1;
                if (Math.abs(left[mid] + right[i] - goal) < Math.abs(left[l] + right[i] - goal)) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            ans = Math.min(ans, Math.abs(left[l] + right[i] - goal));
        }
        return ans;
    }
}