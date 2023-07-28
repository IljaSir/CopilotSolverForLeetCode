class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        return count(nums1, nums2) + count(nums2, nums1);
    }
    
    private int count(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                long prod = (long) nums2[i] * nums2[j];
                map.put(prod, map.getOrDefault(prod, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
         
        return count;
    }
}