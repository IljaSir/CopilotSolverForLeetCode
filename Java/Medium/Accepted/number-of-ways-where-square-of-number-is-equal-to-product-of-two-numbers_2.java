class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        
        int count = 0;
        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            long num = (long) nums1[i] * nums1[i];
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            long num = (long) nums2[i] * nums2[i];
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        count += helper(map1, nums2);
        count += helper(map2, nums1);
        return count;
    }
    
    private int helper(Map<Long, Integer> map, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long num = (long) nums[i] * nums[j];
                if (map.containsKey(num)) {
                    count += map.get(num);
                }
            }
        }
        return count;
    }
}