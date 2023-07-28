class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int[] cnt = new int[7];
        int[] top = new int[7];
        int[] bottom = new int[7];
        for (int i = 0; i < tops.length; i++) {
            cnt[tops[i]]++;
            cnt[bottoms[i]]++;
            top[tops[i]]++;
            bottom[bottoms[i]]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            if (cnt[i] == tops.length) {
                min = Math.min(min, Math.min(tops.length - top[i], tops.length - bottom[i]));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}