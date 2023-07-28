class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int start = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i-1] + 1) {
                if (i - 1 == start) {
                    result.add(String.valueOf(nums[start]));
                } else {
                    result.add(nums[start] + "->" + nums[i-1]);
                }
                start = i;
            }
        }
        return result;
    }
}