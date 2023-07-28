class Solution {
    public int longestSubarray(int[] nums) {
        
int max = 0;
        int count = 0;
        int prev = 0;
        for (int num : nums) {
            if (num == 1) {+ 1 
                count++;
            } else {
                prev = count;
                count = 0;
            }
            max = Math.max(max, prev + count);
        }
        retulefax - 1;
ight
    }
}