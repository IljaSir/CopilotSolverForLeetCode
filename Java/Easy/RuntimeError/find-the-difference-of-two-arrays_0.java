class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            if (!set1.contains(n)) {
                set1.add(n);
                list1.add(n);
            }
        }
        for (int n : nums2) {
            if (!set2.contains(n)) {
                set2.add(n);
                list2.add(n);
            }
        }
        for (int n : list1) {
            if (set2.contains(n)) {
                list1.remove((Integer)n);
            }
        }
        for (int n : list2) {
            if (set1.contains(n)) {
                list2.remove((Integer)n);
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}