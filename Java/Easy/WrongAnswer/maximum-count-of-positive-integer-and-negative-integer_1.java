class Solution {
    public int maximumCount(int[] nums) {
        
        int pos = 0;
        int neg = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;
            } else if (nums[i] < 0) {
                neg++;
            }
            if (i > 0 && nums[i] != nums[i - 1]) {
                max = Math.max(max, Math.max(pos, neg));
                pos = 0;
                neg = 0;
            }
        }
        max = Math.max(max, Math.max(pos, neg));
        return max;
    }
}