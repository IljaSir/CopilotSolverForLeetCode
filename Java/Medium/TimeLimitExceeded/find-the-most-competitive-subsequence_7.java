class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[k];
        int start = 0;
        int end = n - k;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    start = j + 1;
                }
            }
            res[i] = min;
            end++;
        }
        return res;
    }
}