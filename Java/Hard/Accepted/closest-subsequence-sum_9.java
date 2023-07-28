class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1<<(n/2)];
        int[] right = new int[1<<(n-n/2)];
        int l = 0, r = 0;
        for (int i = 0; i < 1<<(n/2); i++) {
            for (int j = 0; j < n/2; j++) {
                if ((i>>j&1) == 1) {
                    left[l] += nums[j];
                }
            }
            l++;
        }
        for (int i = 0; i < 1<<(n-n/2); i++) {
            for (int j = 0; j < n-n/2; j++) {
                if ((i>>j&1) == 1) {
                    right[r] += nums[n/2+j];
                }
            }
            r++;
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            int idx = Arrays.binarySearch(right, goal-left[i]);
            if (idx >= 0) {
                return 0;
            }
            idx = -idx-1;
            if (idx < r) {
                ans = Math.min(ans, Math.abs(goal-left[i]-right[idx]));
            }
            if (idx > 0) {
                ans = Math.min(ans, Math.abs(goal-left[i]-right[idx-1]));
            }
        }
        return ans;
    }
}