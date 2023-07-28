class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int i = start; i < start + groupSize; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                if (map.get(i) == 1) {
                    map.remove(i);
                } else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        return true;
    }
}