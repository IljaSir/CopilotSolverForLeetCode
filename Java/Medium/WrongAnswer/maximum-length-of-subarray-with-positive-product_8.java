class Solution {
    public int getMaxLen(int[] nums) {
        
        int max = 0;
        int count = 0;
        int neg = 0;
        int firstNeg = -1;
        int firstNegPos = -1;
        int lastNeg = -1;
        int lastNegPos = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (neg % 2 == 0) {
                    max = Math.max(max, count);
                } else {
                    max = Math.max(max, Math.max(count - firstNegPos, lastNegPos));
                }
                count = 0;
                neg = 0;
                firstNeg = -1;
                firstNegPos = -1;
                lastNeg = -1;
                lastNegPos = -1;
            } else {
                ++count;
                if (nums[i] < 0) {
                    ++neg;
                    if (firstNeg == -1) {
                        firstNeg = nums[i];
                        firstNegPos = count;
                    }
                    lastNeg = nums[i];
                    lastNegPos = count;
                }
            }
        }
        if (neg % 2 == 0) {
            max = Math.max(max, count);
        } else {
            max = Math.max(max, Math.max(count - firstNegPos, lastNegPos));
        }
        return max;
    }
}