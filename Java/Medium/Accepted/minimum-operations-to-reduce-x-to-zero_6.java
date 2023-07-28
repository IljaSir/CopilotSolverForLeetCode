class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] psum = new int[n+1];
        for (int i = 0; i < n; i++) {
            psum[i+1] = psum[i] + nums[i];
        }
        int target = psum[n] - x;
        if (target < 0) return -1;
        if (target == 0) return n;
        int res = -1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (left <= right && psum[right+1] - psum[left] > target) {
                left++;
            }
            if (psum[right+1] - psum[left] == target) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res == -1 ? -1 : n - res;
    }
}