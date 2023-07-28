class Solution {
    public int findMinMoves(int[] machines) {
        
        int n = machines.length;
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += machines[i] - avg;
            ans = Math.max(ans, Math.max(Math.abs(cnt), machines[i] - avg));
        }
        return ans;
    }
}