class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                list1.add(nums1[i++]);
            } else if (nums1[i] > nums2[j]) {
                list2.add(nums2[j++]);
            } else {
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            list1.add(nums1[i++]);
        }
        while (j < nums2.length) {
            list2.add(nums2[j++]);
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}