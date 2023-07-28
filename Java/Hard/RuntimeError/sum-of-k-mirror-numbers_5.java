class Solution {
    public long kMirror(int k, int n) {
        
        long res = 0;
        int[] nums = new int[n];
        int[] digits = new int[30];
        int len = 0;
        for (int i = 1; i < k; i++) {
            nums[0] = i;
            len = 1;
            while (len < n) {
                for (int j = 0; j < len; j++) {
                    nums[len + j] = nums[j];
                }
                len *= 2;
                for (int j = 0; j < len; j++) {
                    nums[j] *= k;
                }
            }
            for (int j = 0; j < len; j++) {
                res += nums[j];
            }
        }
        return res;
    }
}