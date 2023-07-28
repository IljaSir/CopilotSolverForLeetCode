class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(hand);
        for (int i : hand) {
            if (map.get(i) == 0) {
                continue;
            }
            for (int j = i; j < i + groupSize; j++) {
                if (!map.containsKey(j) || map.get(j) == 0) {
                    return false;
                }
                map.put(j, map.get(j) - 1);
            }
        }
        return true;
    }
}