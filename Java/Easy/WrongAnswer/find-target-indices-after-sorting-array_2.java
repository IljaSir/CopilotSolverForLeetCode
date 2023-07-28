class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == target) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == target) {
                        result.add(j);
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        return result;
    }
}