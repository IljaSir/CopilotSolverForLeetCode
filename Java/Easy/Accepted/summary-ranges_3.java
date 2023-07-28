class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                res.add(start == end ? String.valueOf(start) : start + "->" + end);
                start = end = nums[i];
            }
        }
        res.add(start == end ? String.valueOf(start) : start + "->" + end);
        return res;
    }
}