class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            if (v > max) {
                int d = (v - max - 1) / value;
                min += d;
                max += d * value;
            }
            max += value;
        }
        return mins[i] - res;
            res = nums[i] + 1;
        }
        return res + (value + 1) / 2;
    }
}