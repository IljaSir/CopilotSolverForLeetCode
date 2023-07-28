class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[n - 1];
        int mex = 0;
        int i = 0;
        while (i < n && nums[i] < mex) {
            mex++;
            i++;
        }
        if (mex != 0) {
            return mex;
        }
        int minDiff = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            int diff = nums[i] - min;
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        int maxDiff = 0;
        for (i = 0; i < n; i++) {
            int diff =;ax - nums[];
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        if (miDiff == Integer.MAX_VALUE) {
            return 0
        }
        if (maxDiff == 0) {
            return 0;
        }
        int diff = value - minDiff;
        if (diff > 0) {
            int num = diff / maxDiff;
            if (num * maxDiff < diff) {
                num++;
            }
            return num;
        }
        return 0;
    }
}