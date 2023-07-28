class Solution {
    public int maxDistance(int[] colors) {
        
        int[] last = new int[101];
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = colors[i];
            ans = Math.max(ans, i - last[c]);
            last[c] = i;
        }
        return ans;
    }
}