class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length, max = 0;
        int[] last = new int[101];
        for(int i = 0; i < n; i++) {
            max = Math.max(max, i - last[colors[i]]);
            last[colors[i]] = i;
        }
        return max;
    }
}