class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] count = new int[n];
        int[] score = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            count[i] = 1;
            score[i] = 1;
            if (parents[i] != -1) {
                count[parents[i]] += count[i];
                score[parents[i]] *= score[i] + count[i];
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, score[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] == max) {
                ans++;
            }
        }
        return ans;
    }
}