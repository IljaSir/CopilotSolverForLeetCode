class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) {
            return 0;
        }
        int[] a1 = new int[6];
        int[] a2 = new int[6];
        for (int i = 0; i < nums1.length; i++) {
            a1[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            a2[nums2[i] - 1]++;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (sum1 > sum2) {
            int d = sum1 - sum2;
            int c = 0;
            int i = 5;
            while (d > 0) {
                if (a1[i] == 0) {
                    i--;
                    continue;
                }
                int t = Math.min(d / (i + 1), a1[i]);
                d -= t * (i + 1);
                a1[i] -= t;
                c += t;
            }
            return c;
        } else {
            int d = sum2 - sum1;
            int c = 0;
            int i = 0;
            while (d > 0) {
                if (a2[i] == 0) {
                    i++;
                    continue;
                }
                int t = Math.min(d / (6 - i), a2[i]);
                d -= t * (6 - i);
                a2[i] -= t;
                c += t;
            }
            return c;
        }
    }
}