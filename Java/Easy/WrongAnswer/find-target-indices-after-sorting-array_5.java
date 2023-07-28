class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<>();
        int[] copy = nums.clone();
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] == target) {
                list.add(Arrays.binarySearch(nums, target));
            }
        }
        return list;
    }
}