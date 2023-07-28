class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int n = deck.length;
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        Arrays.sort(deck);
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return res;
    }
}