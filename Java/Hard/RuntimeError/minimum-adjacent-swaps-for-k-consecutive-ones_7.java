class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        int[] a = new int[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                a[j++] = i;
            }
        }
        int median = a[k / 2];
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += Math.abs(a[i] - median) - Math.abs(i - k / 2);
        }
        return res;
    }
}