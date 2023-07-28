class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        List<Integer> res = new ArrayList<>();
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(Arrays.binarySearch(copy, target));
            }
        }
        return res;
    }
}