class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        int[] playerWins = new int[100001];
        int[] playerLosses = new int[100001];
        for (int[] match : matches) {
            playerWins[match[0]]++;
            playerLosses[match[1]]++;
        }
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (int i = 1; i < 100001; i++) {
            if (playerWins[i] > 0 && playerLosses[i] == 0) {
                winners.add(i);
            } else if (playerLosses[i] == 1) {
                losers.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(winners);
        result.add(losers);
        return result;
    }
}