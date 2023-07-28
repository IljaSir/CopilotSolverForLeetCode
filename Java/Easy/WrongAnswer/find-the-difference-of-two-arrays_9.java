class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                list.add(nums1[i]);
            }
        }
        res.add(list);
        list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            boolean isExist = false;
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                list.add(nums2[i]);
            }
        }
        res.add(list);
        return res;
    }
}