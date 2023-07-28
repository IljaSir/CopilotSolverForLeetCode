class Solution {
    public int getMaxLen(int[] nums) {
        
        int neg = 0, pos = 0, max = 0;
        for (int num : nums) {
            if (num == 0) {
                neg = pos = 0;
            } else if (num > 0) {
                pos++;
                if (neg > 0) {
                    neg++;
                }
            } else {
                int tmp = neg;
                neg = pos + 1;
                pos = tmp > 0 ? tmp + 1 : 0;
            }
            max = Math.max(max, pos);
        }
        return max;
    }
}