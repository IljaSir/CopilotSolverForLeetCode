class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + nums[i];
            right[i + 1] = right[i] + nums[n - 1 - i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (left[i] > x) {
                break;
            }
            int target = x - left[i];
            int bound = Arrays.binarySearch(right, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n && right[bound] == target) {
                int total = i + bound;
                if (total <= n) {
                    ans = Math.min(ans, total);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}