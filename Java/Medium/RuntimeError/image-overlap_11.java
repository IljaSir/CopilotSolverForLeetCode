class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int n = img1.length;
        int[][] delta = new int[n * n][2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < n; j2++) {
                            if (img2[i2][j2] == 1) {
                                delta[k][0] = i - i2;
                                delta[k++][1] = j - j2;
                            }
                        }
                    }
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            String key = delta[i][0] + "," + delta[i][1];
            int val = map.getOrDefault(key, 0) + 1;
            map.put(key, val);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}