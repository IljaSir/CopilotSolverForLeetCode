class Solution {
    public int minimumCardPickup(int[] cards) {
        
        int n = cards.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!first.containsKey(cards[i])) first.put(cards[i], i);
            left[i] = first.get(cards[i]);
        }
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!last.containsKey(cards[i])) last.put(cards[i], i);
            right[i] = last.get(cards[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            if (l < i && r > i) {
                min = Math.min(min, r - l + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}