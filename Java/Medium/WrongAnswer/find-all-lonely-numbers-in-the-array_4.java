class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        if(nums[0] != nums[1]) {
            result.add(nums[0]);
        }
        for(int i = 1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                result.add(nums[i]);
            }
        }
        if(nums[nums.length - 1] != nums[nums.length - 2]) {
            result.add(nums[nums.length - 1]);
        }
        return result;
    }
}