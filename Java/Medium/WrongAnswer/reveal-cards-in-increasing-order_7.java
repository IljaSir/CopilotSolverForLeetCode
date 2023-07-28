class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        int n = deck.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Arrays.sort(deck);
        int i = 0;
        for (int card: deck) {
            i = findNextEmptySlot(ans, i);
            ans[i] = card;
        }
        return ans;
    }
    
    private int findNextEmptySlot(int[] ans, int i) {
        int n = ans.length;
        int count = 0;
        while (count < 2) {
            if (ans[i] == -1) count++;
            i = (i + 1) % n;
        }
        return i;
    }
}