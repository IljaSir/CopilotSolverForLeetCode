class Solution {
    public int findMinMoves(int[] machines) {
        
        int n = machines.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
        }
        if (sum % n != 0) {
            return -1;
        }
        int avg = sum / n;
        int ans = 0, cnt = 0;
        for (int num : machines) {
            num -= avg;
            cnt += num;
            ans = Math.max(ans, Math.max(Math.abs(cnt), num));
        }
        return ans;
    }
}