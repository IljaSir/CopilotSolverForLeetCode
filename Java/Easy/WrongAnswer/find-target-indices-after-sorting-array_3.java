class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> result = new ArrayList<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(Arrays.binarySearch(sorted, target));
            }
        }
        return result;
    }
}