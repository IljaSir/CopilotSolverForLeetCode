class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    result.add(nums[i]);
                }
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1]) {
                    result.add(nums[i]);
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
}