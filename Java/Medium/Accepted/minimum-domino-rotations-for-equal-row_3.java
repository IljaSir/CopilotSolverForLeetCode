class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int[] sameCount = new int[7];
        for (int i = 0; i < n; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                sameCount[tops[i]]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            if (topCount[i] + bottomCount[i] - sameCount[i] == n) {
                min = Math.min(min, Math.min(topCount[i], bottomCount[i]) - sameCount[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}