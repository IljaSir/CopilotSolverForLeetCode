class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;
        int g = -1;
        for (int i: count) {
            if (i > 0) {
                if (g == -1)
                    g = i;
                else
                    g = gcd(g, i);
            }
        }
        return g >= 2;
    }
}