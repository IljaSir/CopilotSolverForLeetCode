class Solution {
    public long findScore(int[] nums) {
        
        int n = nums.length;
        long score = 0;
        int[] marked = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (marked[j] == 0 && nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                break;
            }
            score += min;
            marked[minIndex] = 1;
            if (minIndex + 1 < n) {
                marked[minIndex + 1] = 1;
            }
            if (minIndex - 1 >= 0) {
                marked[minIndex - 1] = 1;
            }
        }
        return score;
    }
}