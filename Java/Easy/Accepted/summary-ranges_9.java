class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<String>();
        if (nums.length == 0) {
            return result;
        }
        int start = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                result.add(nums[i] == start ? Integer.toString(start) : start + "->" + nums[i]);
                start = nums[i + 1];
            }
        }
        result.add(nums[nums.length - 1] == start ? Integer.toString(start) : start + "->" + nums[nums.length - 1]);
        return result;
    }
}