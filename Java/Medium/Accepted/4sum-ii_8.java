class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int n = nums1.length;
        int[] sum1 = new int[n * n];
        int[] sum2 = new int[n * n];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1[idx1++] = nums1[i] + nums2[j];
                sum2[idx2++] = nums3[i] + nums4[j];
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int ans = 0;
        int l = 0, r = sum2.length - 1;
        while (l < sum1.length && r >= 0) {
            int s1 = sum1[l];
            int s2 = sum2[r];
            if (s1 + s2 == 0) {
                int c1 = 1;
                int c2 = 1;
                while (l < sum1.length - 1 && sum1[l + 1] == s1) {
                    ++l;
                    ++c1;
                }
                while (r > 0 && sum2[r - 1] == s2) {
                    --r;
                    ++c2;
                }
                ans += c1 * c2;
                ++l;
                --r;
            } else if (s1 + s2 < 0) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}