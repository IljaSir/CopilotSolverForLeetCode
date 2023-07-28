class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int n = nums.length;
        int[] cnt = new int[k];
        for (int num : nums) {
            cnt[num % k]++;
        }
        int res = 0;
        if (cnt[0] > 0) {
            res++;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (cnt[i] > 0) {
                    res++;
                }
            } else {
                res += Math.max(cnt[i], cnt[k - i]);
            }
        }
        return res;
    }
}