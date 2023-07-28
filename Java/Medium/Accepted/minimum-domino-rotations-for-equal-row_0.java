class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        int[] top = new int[7];
        int[] bottom = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < n; i++) {
            top[tops[i]]++;
            bottom[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (top[i] + bottom[i] - same[i] == n) {
                return n - Math.max(top[i], bottom[i]);
            }
        }
        return -1;
    }
}