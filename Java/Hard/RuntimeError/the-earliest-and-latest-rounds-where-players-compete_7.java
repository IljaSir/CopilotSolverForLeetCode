class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        int[] players = new int[n];
        int round = 1;
        for (int i = 0; i < n; i++) {
            players[i] = i + 1;
        }
        while (players.length > 1) {
            int[] newPlayers = new int[players.length / 2];
            int idx = 0;
            for (int i = 0; i < players.length; i += 2) {
                if (players[i] == firstPlayer && players[i + 1] == secondPlayer) {
                    res[0] = Math.max(res[0], round);
                    res[1] = Math.max(res[1], round);
                } else if ((players[i] == firstPlayer || players[i] == secondPlayer) && (players[i + 1] != firstPlayer && players[i + 1] != secondPlayer)) {
                    res[0] = Math.max(res[0], round);
                } else if ((players[i + 1] == firstPlayer || players[i + 1] == secondPlayer) && (players[i] != firstPlayer && players[i] != secondPlayer)) {
                    res[0] = Math.max(res[0], round);
                } else if ((players[i] == firstPlayer || players[i] == secondPlayer) && (players[i + 1] == firstPlayer || players[i + 1] == secondPlayer)) {
                    res[1] = Math.max(res[1], round);
                }
                newPlayers[idx++] = players[i];
            }
            players = newPlayers;
            round++;
        }
        return res;
    }
}