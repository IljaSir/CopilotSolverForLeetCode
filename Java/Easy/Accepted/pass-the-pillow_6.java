class Solution {
    public int passThePillow(int n, int time) {
        
        int ans = 1;
        int m = time / (n - 1);
        int r = time % (n - 1);
        if (m % 2 == 0) {
            ans = 1 + r;
        } else {
            ans = n - r;
        }
        return ans;
    }
}