class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = i, r = n + 1;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (nums[mid] - nums[i] <= space) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            ans = Math.max(ans, pre[l + 1] - pre[i]);
        }
        return ans;
    }
}