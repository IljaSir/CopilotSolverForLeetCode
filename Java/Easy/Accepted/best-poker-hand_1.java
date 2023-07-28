class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        
        Map<Character, Integer> suitCount = new HashMap<>();
        for (char suit : suits) {
            suitCount.put(suit, suitCount.getOrDefault(suit, 0) + 1);
        }
        if (suitCount.values().stream().anyMatch(count -> count >= 5)) {
            return "Flush";
        }
        
        Map<Integer, Integer> rankCount = new HashMap<>();
        for (int rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        if (rankCount.values().stream().anyMatch(count -> count >= 3)) {
            return "Three of a Kind";
        }
        if (rankCount.values().stream().anyMatch(count -> count >= 2)) {
            return "Pair";
        }
        return "High Card";
    }
}