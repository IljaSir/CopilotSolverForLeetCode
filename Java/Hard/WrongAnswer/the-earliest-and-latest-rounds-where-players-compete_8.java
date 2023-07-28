class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] result = new int[2];
        int start = 1;
        int end = n;
        int round = 1;
        while (start != firstPlayer && end != firstPlayer && start != secondPlayer && end != secondPlayer) {
            start = (start + 1) / 2;
            end = (end + 1) / 2;
            round++;
        }
        result[0] = round;
        int maxRound = (int) (Math.log(n) / Math.log(2));
        round = maxRound;
        while (start != firstPlayer && end != firstPlayer && start != secondPlayer && end != secondPlayer) {
            start = (start + 1) / 2;
            end = (end + 1) / 2;
            round--;
        }
        result[1] = round;
        return result;
    }
}