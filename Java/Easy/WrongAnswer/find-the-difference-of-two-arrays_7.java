class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> notInNums1 = new ArrayList<>();
        List<Integer> notInNums2 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        for (int n : nums2) {
            if (!set.contains(n)) {
                notInNums1.add(n);
            }
        }
        set.clear();
        for (int n : nums2) {
            set.add(n);
        }
        for (int n : nums1) {
            if (!set.contains(n)) {
                notInNums2.add(n);
            }
        }
        result.add(notInNums1);
        result.add(notInNums2);
        return result;
    }
}