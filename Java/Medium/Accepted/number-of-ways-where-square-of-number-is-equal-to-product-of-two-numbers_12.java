class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        return count(nums1, nums2) + count(nums2, nums1);
    }
    private int count(int[] nums1, int[] nums2) {
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long product = (long) nums1[i] * nums1[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            long square = (long) nums2[i] * nums2[i];
            if (map.containsKey(square)) {
                res += map.get(square);
            }
        }
        return res;
    }
}