class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] trustedBy = new int[n+1];
        int[] trustOthers = new int[n+1];
        
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            trustedBy[b]++;
            trustOthers[a]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustedBy[i] == n-1 && trustOthers[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}