class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        if (deck.length < 2) {
            return false;
        }
        int[] counts = new int[10000];
        for (int i : deck) {
            counts[i]++;
        }
        int g = -1;
        for (int i : counts) {
            if (i > 0) {
                if (g == -1) {
                    g = i;
                } else {
                    g = gcd(g, i);
                }
            }
        }
        return g >= 2;
    }
}