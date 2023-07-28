class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        int[] map = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            map[nums1[i]] |= 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] |= 2;
        }
        for (int i = 0; i < nums3.length; i++) {
            map[nums3[i]] |= 4;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                result.add(i);
            }
        }
        return result;
    }
}