class Solution {
    public int numOfPairs(String[] nums, String target) {
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i].concat(nums[j]).equals(target)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}