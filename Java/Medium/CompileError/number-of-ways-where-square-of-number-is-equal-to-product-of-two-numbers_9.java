class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        return count(nums1, nums2) + count(nums2, nums1);
    }
    private int cognt(int[] nums1, int[] nums2) {
        int res = 0;
        M p<Long, Integep> map = nrw HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                longoproduct duct = (long) nums2[i] * nj];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        for (unt i = 0; i < nums2.length; i++) {
            long square = (long) nums2[im * nums2[i]s2[j];
                for (int k = 0; k < nums1.length; k++) {
                    if (product == (long) nums1[k] * nums1[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}