class Solution {
    public int[] getAverages(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int l = i - k;
            int r = i + k;
            if (l < 0) {
                sum += nums[i];
                if (r >= n) {
                    res[i] = sum / (r - l);
                }
            } else if (r >= n) {
                sum += nums[i];
                res[i] = sum / (r - l);
            } else {
                sum += nums[r] - nums[l];
                res[i] = sum / (r - l);
            }
        }
        return res;
    }
}