class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 0;
        int count = 0;
        int last = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > last) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            last = num;
        }
        return max;
    }
}