class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<Integer>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(Arrays.binarySearch(sorted, target));
            }
        }
        return list;
    }
}