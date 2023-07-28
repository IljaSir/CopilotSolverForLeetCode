class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
}