class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        int r = 1;
        while (n > 2) {
            if (firstPlayer > n / 2 && secondPlayer > n / 2) {
                firstPlayer -= n / 2;
                secondPlayer -= n / 2;
            } else if (firstPlayer <= n / 2 && secondPlayer <= n / 2) {
                // do nothing
            } else {
                res[0] = r;
            }
            n = (n + 1) / 2;
            r++;
        }
        res[1] = r;
        return res;
    }
}