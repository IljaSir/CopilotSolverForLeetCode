class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        return count(nums1, nums2) + count(nums2, nums1);
    }
    private int count(int[] nums1, int[] nums2) {
        int res = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            long n = (long) nums1[i] * nums1[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long n = (long) nums2[i] * nums2[j];
                if (map.containsKey(n)) {
                    res += map.get(n);
                }
            }
        }
        return res;
    }
}