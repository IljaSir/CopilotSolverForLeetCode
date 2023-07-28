class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card: hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        while (!freq.isEmpty()) {
            int start = freq.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!freq.containsKey(start + i)) {
                    return false;
                }
                if (freq.get(start + i) == 1) {
                    freq.remove(start + i);
                } else {
                    freq.put(start + i, freq.get(start + i) - 1);
                }
            }
        }
        return true;
    }
}