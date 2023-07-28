class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[] left = new int[101];
        int[] right = new int[101];
        Arrays.fill(left, n);
        for (int i = 0; i < n; i++) {
            left[colors[i]] = Math.min(left[colors[i]], i);
            right[colors[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (i != j) {
                    ans = Math.max(ans, right[i] - left[j]);
                }
            }
        }
        return ans;
    }
}