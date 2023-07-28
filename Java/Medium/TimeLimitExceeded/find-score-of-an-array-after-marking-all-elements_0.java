class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int[] mark = new int[n];
        long score = 0;
        for (int i = 0; i < n; i++) {
            int idx = -1;
            for (int j = 0; j < n; j++) {
                if (nums[j] == arr[i] && mark[j] == 0) {
                    idx = j;
                    break;
                }
            }
            if (idx >= 0) {
                score += nums[idx];
                mark[idx] = 1;
                if (idx - 1 >= 0) {
                    mark[idx - 1] = 1;
                }
                if (idx + 1 < n) {
                    mark[idx + 1] = 1;
                }
            }
        }
        return score;
    }
}