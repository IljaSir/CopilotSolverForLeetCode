class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for(int i: nums1) {
            set.add(i);
        }
        Set<Integer> resultSet = new HashSet<>();
        for(int i: nums2) {
            if(set.contains(i)) {
                resultSet.add(i);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num: resultSet) {
            result[i++] = num;
        }
        return result;
    }
}