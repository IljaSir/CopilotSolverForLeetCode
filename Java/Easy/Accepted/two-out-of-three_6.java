class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (int i = 0; i < nums3.length; i++) {
            set3.add(nums3[i]);
        }
        for (Integer i : set1) {
            if (set2.contains(i) || set3.contains(i)) {
                set.add(i);
            }
        }
        for (Integer i : set2) {
            if (set3.contains(i)) {
                set.add(i);
            }
        }
        return new ArrayList<>(set);
    }
}