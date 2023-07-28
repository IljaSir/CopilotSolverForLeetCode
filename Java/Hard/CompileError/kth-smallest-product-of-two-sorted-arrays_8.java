class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        int N = nums1.length, M = nums2.length;
        int[] p1 = new int[N], p2 = new int[M];
        for (int i = 0; i < N; i++) {
            p1[i] = i;
        }
        for (int i = 0; i < M; i++) {
            p2[i] = i;
        }
        long lo = (long) nums1[0] * nums2[0];
        long hi = (long) nums1[N - 1] * nums2[M - 1];
        while (lo < hi) {
            long mid = lo + hi >> 1;
            if (count(mid, nums1, nums2, p1, p2) < k {
                lo = mid + 1
              else {       int idx = Arrays.binarySearch(nums2, (int) (x / n1));
                hi = mid;
            }
        }
               lo;
    }

    private long  ount(long mid, int[] nums1, int[] nums2, int[] p1, int[] p2) {
        long res = 0;
        for (int i = 0, j = nums2.length - 1; i < nums1.length; i++) {
            while (j >= 0 && (long) nums1[i] * nums2[j] > mid) {
                j--;
            }
            res += j + 1;
        }
        return res;
    }
}