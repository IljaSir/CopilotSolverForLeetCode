class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int[] topBottom = new int[7];
        for (int i = 0; i < n; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                topBottom[tops[i]]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (topCount[i] + bottomCount[i] - topBottom[i] == n) {
                return n - Math.max(topCount[i], bottomCount[i]);
            }
        }
        return -1;
    }
}