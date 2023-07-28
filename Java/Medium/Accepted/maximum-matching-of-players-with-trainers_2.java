class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int res = 0;
        int j = 0;
        for (int i = 0; i < players.length; i++) {
            while (j < trainers.length && trainers[j] < players[i]) {
                j++;
            }
            if (j < trainers.length && trainers[j] >= players[i]) {
                res++;
                j++;
            }
        }
        return res;
    }
}