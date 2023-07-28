class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        int n = players.length;
        int m = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0, r = m;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (trainers[mid] >= players[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l < m) {
                ++ans;
                ++l;
            }
        }
        return ans;
    }
}