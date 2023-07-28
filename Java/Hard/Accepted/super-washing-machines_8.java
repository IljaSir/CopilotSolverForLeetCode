class Solution {
    public int findMinMoves(int[] machines) {
        
        int n = machines.length;
        int sum = 0;
        for (int m : machines) {
            sum += m;
        }
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int ans = 0;
        int cnt = 0;
        for (int m : machines) {
            cnt += m - avg;
            ans = Math.max(ans, Math.max(Math.abs(cnt), m - avg));
        }
        return ans;
    }
}