class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] trustCount = new int[n];
        for (int[] t : trust) {
            trustCount[t[0] - 1]--;
            trustCount[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (trustCount[i] == n - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}