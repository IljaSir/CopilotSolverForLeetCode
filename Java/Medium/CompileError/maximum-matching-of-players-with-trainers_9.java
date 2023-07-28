class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length;
        int m = trainers.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int low = 0;
            int high = m - 1;
            int mid = 0;
            while(low <= high) {
                mid = low + (high - low)/2;
                if(trainers[mid] >= players[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            rn res;
    }
}