class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        List<Integer> result = new ArrayList<>();
        int[] count = new int[101];
        for (int i : nums1) {
            count[i] = 1;
        }
        for (int i : nums2) {
            count[i] = count[i] == 1 ? 2 : 1;
        }
        for (int i : nums3) {
            count[i] = count[i] == 2 ? 2 : count[i] == 1 ? 3 : 0;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] >= 2) {
                result.add(i);
            }
        }
        return result;
    }
}