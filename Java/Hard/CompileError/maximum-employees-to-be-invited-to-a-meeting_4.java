class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] color = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = i;
            size[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = find(color, i);
            int k = find(color, favorite[i]);
            if (j != k) {
                color[j] = k;
                size[k] += size[j];
            }
            max = Math.max(max, size[k]);
        }
        return max;
    }
}