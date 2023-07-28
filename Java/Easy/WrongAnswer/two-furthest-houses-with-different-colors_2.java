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
        for (int i = 0; i < 101; i++) {
            for (int j = i + 1; j < 101; j++) {
                ans = Math.max(ans, Math.abs(left[i] - right[j]));
                ans = Math.max(ans, Math.abs(left[j] - right[i]));
            }
        }
        return ans;
    }
}