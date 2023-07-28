class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        Set<Integer> set3 = new HashSet<>();
        for (int i : set1) {
            if (set2.contains(i)) {
                set3.add(i);
            }
        }
        int[] result = new int[set3.size()];
        int i = 0;
        for (int j : set3) {
            result[i++] = j;
        }
        return result;
    }
}