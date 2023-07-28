class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        int[] count = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            count[nums2[i]]++;
        }
        for (int i = 0; i < nums3.length; i++) {
            count[nums3[i]]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            if (count[i] > 1) {
                result.add(i);
            }
        }
        return result;
    }
}