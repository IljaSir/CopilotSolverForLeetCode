class Solution {
    public int bestRotation(int[] nums) {
        
        int n = nums.length;
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[(i - nums[i] + 1 + n) % n]--;
        }
        for (int i = 1; i < n; i++) {
            score[i] += score[i - 1] + 1;
        }
        int maxScore = score[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                ans = i;
            }
        }
        return ans;
    }
}