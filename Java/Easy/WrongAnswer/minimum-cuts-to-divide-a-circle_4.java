class Solution {
    public int numberOfCuts(int n) {
        
        int cuts = 0;
        int current = n;
        while (current > 1) {
            cuts++;
            current = (current + 1) / 2;
        }
        return cuts;
    }
}