class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        for (int card : deck) {
            res[queue.pollFirst()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.pollFirst());
            }
        }
        return res;
    }
}