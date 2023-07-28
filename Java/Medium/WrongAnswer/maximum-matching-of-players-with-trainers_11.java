class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length, m = trainers.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (trainers[mid] >= players[i]) l = mid;
                else r = mid - 1;
            }
            if (trainers[l] >= players[i]) res++;
        }
        return res;
    }
}