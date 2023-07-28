class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        
        int n = nums.length;
        int[] res = new int[k];
        int idx = 0;
        int start = 0;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = start; j < n - k + i + 1; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    start = j + 1;
                }
            }
            res[idx++] = min;
        }
        return res;
    }
}