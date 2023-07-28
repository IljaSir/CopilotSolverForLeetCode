class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        int ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < n; i++) {
            ans ^= nums1[i];
        }
        for (int i = 0; i < m; i++) {
            ans ^= nums2[i];
        }
        return ans;
    }
    public int xorAllPairings(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < n; i++) {
            ans ^= nums1[i];
        }
        for (int i = 0; i < m; i++) {
            ans ^= nums2[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans ^= nums1[i] ^ nums2[j];
            }
        }
        return ans;
    }
}