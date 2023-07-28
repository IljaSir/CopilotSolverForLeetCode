class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int index = i;
            if (i + 1 < n && nums[i + 1] < min) {
                min = nums[i + 1];
                index = i + 1;
            }
            if (i - 1 >= 0 && nums[i - 1] < min) {
                min = nums[i - 1];
                index = i - 1;
            }
            res += min;
            for (int j = index - 1; j <= index + 1; j++) {
                if (j >= 0 && j < n) {
                    nums[j] = Integer.MAX_VALUE;
                }
            }
        }
        return res;
    }
}