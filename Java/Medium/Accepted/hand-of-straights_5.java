class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> counts = new TreeMap<Integer, Integer>();
        for (int card: hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }
        for (int card: counts.keySet()) {
            int count = counts.get(card);
            if (count > 0) {
                for (int i = card; i < card + groupSize; i++) {
                    if (!counts.containsKey(i) || counts.get(i) < count) {
                        return false;
                    }
                    counts.put(i, counts.get(i) - count);
                }
            }
        }
        return true;
    }
}