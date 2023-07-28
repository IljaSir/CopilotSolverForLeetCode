class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        res[0] = findRound(n, firstPlayer, secondPlayer, true);
        res[1] = findRound(n, firstPlayer, secondPlayer, false);
        return res;
    }
    
    private int findRound(int n, int firstPlayer, int secondPlayer, boolean earliest) {
        int round = 1;
        while (n > 1) {
            if (firstPlayer <= n / 2 && secondPlayer > n / 2) {
                return round;
            }
            if (firstPlayer > n / 2) {
                firstPlayer -= n / 2;
            }
            if (secondPlayer > n / 2) {
                secondPlayer -= n / 2;
            }
            if (earliest) {
                n = n / 2;
            } else {
                n = (n + 1) / 2;
            }
            round++;
        }
        return round;
    }
}