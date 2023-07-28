class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        int min = Math.min(firstPlayer, secondPlayer);
        int max = Math.max(firstPlayer, secondPlayer);
        int round = 0;
        while (n > 1) {
            n /= 2;
            round++;
            if (n >= min && n < max) {
                res[0] = round;
                res[1] = round;
            } else if (n >= max) {
                min = min * 2 - 1;
            } else {
                max = max * 2 - 1;
            }
        }
        return res;
    }
}