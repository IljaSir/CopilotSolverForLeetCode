class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;
        int[] moves = new int[2 * limit + 2];
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int min = Math.min(nums[i], nums[j]) + 1;
            int max = Math.max(nums[i], nums[j]) + limit;
            moves[min]--;
            moves[nums[i] + nums[j]]--;
            moves[nums[i] + nums[j] + 1]++;
            moves[max + 1]++;
        }
        int minMoves = n;
        int currMoves = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            currMoves += moves[i];
            minMoves = Math.min(minMoves, currMoves);
        }
        return minMoves;
    }
}