class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int unhappyFriends = 0;
        int[] pairings = new int[n];
        for (int[] pair : pairs) {
            pairings[pair[0]] = pair[1];
            pairings[pair[1]] = pair[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                if (preferences[i][j] == pairings[i]) {
                    break;
                }
                int pair = pairings[preferences[i][j]];
                for (int k = 0; k < preferences[pair].length; k++) {
                    if (preferences[pair][k] == i) {
                        unhappyFriends++;
                        break;
                    }
                    if (preferences[pair][k] == pairings[pair]) {
                        break;
                    }
                }
            }
        }
        return unhappyFriends;
    }
}