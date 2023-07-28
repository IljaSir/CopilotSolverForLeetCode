class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end = nums[i];
            } else {
                String s = start == end ? String.valueOf(start) : (start + "->" + end);
                res.add(s);
                start = nums[i];
                end = nums[i];
            }
        }
        String s = start == end ? String.valueOf(start) : (start + "->" + end);
        res.add(s);
        return res;
    }
}