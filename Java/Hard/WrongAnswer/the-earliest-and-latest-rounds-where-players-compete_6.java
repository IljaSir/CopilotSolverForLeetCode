class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        int round = 0;
        while (n > 1) {
            round++;
            if (firstPlayer % 2 == 1 && secondPlayer == firstPlayer + 1) {
                res[0] = round;
                res[1] = round;
                break;
            }
            if (firstPlayer % 2 == 0 && firstPlayer == secondPlayer + 1) {
                res[0] = round;
                res[1] = round;
                break;
            }
            if (firstPlayer % 2 == 1 && secondPlayer % 2 == 0) {
                res[1] = round;
            }
            if (firstPlayer % 2 == 0 && secondPlayer % 2 == 1) {
                res[1] = round;
            }
            firstPlayer = (firstPlayer + 1) / 2;
            secondPlayer = (secondPlayer + 1) / 2;
            n = (n + 1) / 2;
        }
        return res;
    }
}