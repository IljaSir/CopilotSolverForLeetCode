class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new TreeMap<>();
        for (int card: hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }
        for (int card: count.keySet()) {
            int c = count.get(card);
            if (c > 0) {
                for (int i = card; i < card + groupSize; i++) {
                    int cc = count.getOrDefault(i, 0);
                    if (cc < c) {
                        return false;
                    }
                    count.put(i, cc - c);
                }
            }
        }
        return true;
    }
}