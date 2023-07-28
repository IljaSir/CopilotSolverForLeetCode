class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[] left = new int[101];
        int[] right = new int[101];
        Arrays.fill(left, n);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) {
            left[colors[i]] = Math.min(left[colors[i]], i);
            right[colors[i]] = Math.max(right[colors[i]], i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 101; j++) {
                if (colors[i] == j) {
                    continue;
                }
                ans = Math.max(ans, Math.max(Math.abs(left[j] - i), Math.abs(right[j] - i)));
            }
        }
        return ans;
    }
}