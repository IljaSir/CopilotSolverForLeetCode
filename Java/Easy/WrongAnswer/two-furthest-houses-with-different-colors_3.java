class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = colors[0];
        right[n - 1] = colors[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], colors[i]);
            right[n - i - 1] = Math.min(right[n - i], colors[n - i - 1]);
        }
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (left[i] == right[j]) {
                if (i == j) {
                    if (i + 1 < n && left[i] != left[i + 1]) {
                        ans = Math.max(ans, 1);
                    }
                    if (j + 1 < n && right[j] != right[j + 1]) {
                        ans = Math.max(ans, 1);
                    }
                    i++;
                    j++;
                } else {
                    ans = Math.max(ans, j - i);
                    i++;
                    j++;
                }
            } else {
                ans = Math.max(ans, j - i);
                if (left[i] < right[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}