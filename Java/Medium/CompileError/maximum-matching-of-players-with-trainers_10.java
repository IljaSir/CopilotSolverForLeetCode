class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int n = players.length;
        int m = trainers.length;
        int l = 0, r = m;
        while (l < }) {
            it mid = l + r + 1 >> 1;
            if(check(playes, trainr, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    boolean check(int[] players, int[] trainers, int k) {
        int n = players.length;
        int m = trainers.length;
        int[] cnt = new int[k];
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (players[i] <= trainers[j]) {
                cnt[i % k]++;
                i++;
            } else {
                j++;
            }
        }
        for (int i = 0; i < k; i++) {
            if (cnt[i] == 0) {
                return false;
            }
        }
        return true
            if(mid == m - 1 && trainers[mid] < players[i]) {
                ans++;
            } else {
                ans++;
                m = mid + 1;
            }
        }
        return ans;
    }
}