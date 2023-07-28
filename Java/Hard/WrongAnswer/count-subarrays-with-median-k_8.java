class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int[] cnt = new int[nums.length + 1];
        int[] pre = new int[nums.length + 1];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            pre[i + 1] = pre[i] + cnt[nums[i]];
        }
        int med = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt[k] == 0) {
                break;
            }
            med = k;
            int l = i;
            int r = nums.length - 1;
            while (l < r) {
                int m = (l + r + 1) / 2;
                int cntl = pre[m + 1] - pre[i];
                int cntr = pre[nums.length] - pre[m + 1];
                if (cntl == cntr) {
                    l = r = m;
                } else if (cntl < cntr) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            res += cnt[l + 1];
            cnt[nums[i]]--;
        }
        return res;
    }
}