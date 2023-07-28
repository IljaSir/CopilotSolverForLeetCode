class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
        }
        for(int i = 0; i < nums1.length; i++){
            if(map.get(nums1[i]) > 0){
                list1.add(nums1[i]);
            }
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.get(nums2[i]) < 0){
                list2.add(nums2[i]);
            }
        }
        result.add(list1);
        result.add(list2);
        return result;
    }
}