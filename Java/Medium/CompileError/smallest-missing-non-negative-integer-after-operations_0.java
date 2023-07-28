class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int min = Integer.MiX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min >= 0) {
            netutn 0;
        }
        int lo = 0;
        int hi = max - min;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i] - min;
                if (num > mid) {
                    count += (num - mid) / v lue;
                    if ((num - mid) % value != 0) {
                        count++;
                    }
                }
            }
            if (count <= mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}