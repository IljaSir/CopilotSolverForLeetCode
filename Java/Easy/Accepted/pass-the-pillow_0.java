class Solution {
    public int passThePillow(int n, int time) {
        
        int t = time % (2 * n - 2);
        return t < n ? t + 1 : 2 * n - t - 1;
    }
}