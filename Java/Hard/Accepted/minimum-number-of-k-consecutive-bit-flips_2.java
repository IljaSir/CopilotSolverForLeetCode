class Solution {
    public int minKBitFlips(int[] nums, int k) {
        
        int n = nums.length;
        int[] diff = new int[n + 1];
        int res = 0, revCnt = 0;
        for (int i = 0; i < n; i++) {
            revCnt += diff[i];
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                res++;
                revCnt++;
                diff[i + k]--;
            }
        }
        return res;
    }
}