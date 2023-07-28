class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int[] cnt1 = new int[6];
        int[] cnt2 = new int[6];
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums1) {
            cnt1[i - 1]++;
            sum1 += i;
        }
        for (int i : nums2) {
            cnt2[i - 1]++;
            sum2 += i;
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            int[] tmp = cnt1;
            cnt1 = cnt2;
            cnt2 = tmp;
            int t = sum1;
            sum1 = sum2;
            sum2 = t;
        }
        int diff = sum2 - sum1;
        int res = 0;
        for (int i = 5; i >= 0; i--) {
            if (diff == 0) {
                return res;
            }
            int max = Math.min(cnt2[i], (diff - 1) / (6 - i) + 1);
            res += max;
            diff -= max * (6 - i);
        }
        return diff == 0 ? res : -1;
    }
}