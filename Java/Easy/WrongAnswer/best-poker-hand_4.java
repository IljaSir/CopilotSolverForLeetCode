class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (int rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        List<Integer> rankList = new ArrayList<>(rankCount.keySet());
        Collections.sort(rankList, Collections.reverseOrder());
        int maxCount = 0;
        for (int rank : rankList) {
            maxCount = Math.max(maxCount, rankCount.get(rank));
        }
        if (maxCount == 5) {
            return "Flush";
        } else if (maxCount == 3) {
            return "Three of a Kind";
        } else if (maxCount == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}