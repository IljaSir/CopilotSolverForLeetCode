class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        
        int s1 = 0;
        int s2 = 0;
        int[] c1 = new int[7];
        int[] c2 = new int[7];
        for (int i = 0; i < nums1.length; i++) {
            s1 += nums1[i];
            c1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            s2 += nums2[i];
            c2[nums2[i]]++;
        }
        if (s1 == s2) return 0;
        if (s1 > s2) {
            int[] tmp = c1;
            c1 = c2;
            c2 = tmp;
            int tmp2 = s1;
            s1 = s2;
            s2 = tmp2;
        }
        int d = s2 - s1;
        int r = 0;
        for (int i = 1; i < 7; i++) {
            int t = Math.min(c1[i], d / (7 - i));
            r += t;
            d -= t * (7 - i);
            if (d == 0) return r;
        }
        for (int i = 6; i > 0; i--) {
            int t = Math.min(c2[i], d / i);
            r += t;
            d -= t * i;
            if (d == 0) return r;
        }
        return -1;
    }
}