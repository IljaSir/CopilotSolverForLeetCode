class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[] left = new int[101];
        int[] right = new int[101];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) {
            if (left[colors[i]] == -1) {
                left[colors[i]] = i;
            } else {
                right[colors[i]] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = i + 1; j < 101; j++) {
                if (left[i] != -1 && left[j] != -1) {
                    ans = Math.max(ans, Math.abs(left[i] - left[j]));
                }
                if (left[i] != -1 && right[j] != -1) {
                    ans = Math.max(ans, Math.abs(left[i] - right[j]));
                }
                if (right[i] != -1 && left[j] != -1) {
                    ans = Math.max(ans, Math.abs(right[i] - left[j]));
                }
                if (right[i] != -1 && right[j] != -1) {
                    ans = Math.max(ans, Math.abs(right[i] - right[j]));
                }
            }
        }
        return ans;
    }
}