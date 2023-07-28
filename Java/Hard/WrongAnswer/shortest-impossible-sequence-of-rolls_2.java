class Solution {
    public int shortestSequence(int[] rolls, int k) {
        
        int n = rolls.length;
        int[] d = new int[n+1];
        for (int i = 0; i < n; i++) {
            d[i+1] = d[i] + (rolls[i] == k ? -1 : 1);
        }
        int res = n;
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (d[i+1] <= min) {
                min = d[i+1];
                res = Math.min(res, i + 1);
            }
        }
        return res;
    }
}