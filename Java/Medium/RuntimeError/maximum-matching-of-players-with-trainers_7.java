class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int left = 0;
        int right = players.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMatch(players, trainers, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private boolean canMatch(int[] players, int[] trainers, int k) {
        for (int i = 0; i < k; i++) {
            if (players[i] > trainers[trainers.length - k + i]) {
                return false;
            }
        }
        return true;
    }
}