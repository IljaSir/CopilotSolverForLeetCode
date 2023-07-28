class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        int[] count1 = new int[2001];
        int[] count2 = new int[2001];
        for (int num : nums1) {
            count1[num + 1000]++;
        }
        for (int num : nums2) {
            count2[num + 1000]++;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (count1[i] > 0 && count2[i] == 0) {
                list1.add(i - 1000);
            }
            if (count2[i] > 0 && count1[i] == 0) {
                list2.add(i - 1000);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}