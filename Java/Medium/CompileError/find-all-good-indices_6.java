class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
>();
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i < k) {
                pre[i] = Math.max(pre[i - 1], nums[i]);
            }
            if (i > n - k - 1) {
                suf[n - i - 1] = Math.min(suf[n - i], nums[n - i - 1]);
            }
        }
        for (int i = k; i < n - k; i++) {
            if (pre[i - 1] <= suf[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }
}