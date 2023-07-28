class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(max, lis[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                min = Math.min(min, n - lis[i] - lds[i] + 1);
            }
        }
        return min;
    }
}