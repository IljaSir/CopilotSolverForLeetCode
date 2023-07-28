class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (a == nums[i]) {
                res.add("" + a);
            } else {
                res.add(a + "->" + nums[i]);
            }
        }
        return res;
    }
}