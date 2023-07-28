class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        int[] count = new int[101];
        for (int num : nums1) {
            count[num]++;
        }
        for (int num : nums2) {
            count[num]++;
        }
        for (int num : nums3) {
            count[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                result.add(i);
            }
        }
        return result;
    }
}