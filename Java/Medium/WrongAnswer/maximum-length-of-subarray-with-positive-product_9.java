class Solution {
    public int getMaxLen(int[] nums) {
        
        int n = nums.length;
        int max = 0, firstNegIdx = -1, lastNegIdx = -1, lastZeroIdx = -1;
        int cur = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, i - lastZeroIdx - 1);
                lastZeroIdx = i;
                firstNegIdx = lastNegIdx = -1;
                cur = 1;
            } else {
                cur *= nums[i];
                if (cur < 0) {
                    if (firstNegIdx == -1) {
                        firstNegIdx = i;
                    }
                    lastNegIdx = i;
                } else {
                    max = Math.max(max, i - lastZeroIdx);
                }
                if (firstNegIdx != -1) {
                    max = Math.max(max, i - firstNegIdx);
                }
            }
        }
        return max;
    }
}