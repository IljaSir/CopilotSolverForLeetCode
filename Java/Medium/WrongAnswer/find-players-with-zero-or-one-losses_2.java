class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        for (int[] match : matches) {
            winners.add(match[0]);
            losers.add(match[1]);
        }
        List<Integer> winnerList = new ArrayList<>(winners);
        List<Integer> loserList = new ArrayList<>(losers);
        Collections.sort(winnerList);
        Collections.sort(loserList);
        result.add(winnerList);
        result.add(loserList);
        return result;
    }
}