class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] cnt = new int[101];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            left[i] = ++cnt[colors[i]];
            max = Math.max(max, left[i]);
        }
        cnt = new int[101];
        for (int i = n - 1; i >= 0; --i) {
            right[i] = ++cnt[colors[i]];
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] == max) {
                for (int j = 0; j < n; ++j) {
                    if (colors[i] != colors[j]) {
                        res = Math.max(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }
}
    }
}