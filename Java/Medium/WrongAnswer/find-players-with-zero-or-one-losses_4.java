class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];
            if (!map.containsKey(winner)) {
                winners.add(winner);
            }
            if (map.getOrDefault(loser, 0) == 1) {
                losers.add(loser);
            }
        }
        res.add(winners);
        res.add(losers);
        return res;
    }
}