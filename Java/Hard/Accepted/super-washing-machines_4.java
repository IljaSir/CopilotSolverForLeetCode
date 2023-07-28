class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int avg = sum / machines.length;
        int ans = 0;
        int cur = 0;
        for (int machine : machines) {
            machine -= avg;
            cur += machine;
            ans = Math.max(ans, Math.max(Math.abs(cur), machine));
        }
        return ans;
    }
}