class Solution {
    public int numOfPairs(String[] nums, String target) {
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i].length() + nums[j].length() != target.length()) {
                    continue;
                }
                if (nums[i].equals(target.substring(0, nums[i].length())) && nums[j].equals(target.substring(nums[i].length()))) {
                    result++;
                }
                if (nums[j].equals(target.substring(0, nums[j].length())) && nums[i].equals(target.substring(nums[j].length()))) {
                    result++;
                }
            }
        }
        return result;
    }
}