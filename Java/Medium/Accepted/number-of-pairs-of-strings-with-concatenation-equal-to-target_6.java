class Solution {
    public int numOfPairs(String[] nums, String target) {
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i].length() + nums[j].length() == target.length()) {
                    if (target.equals(nums[i] + nums[j])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}