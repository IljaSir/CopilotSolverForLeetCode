class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        int n = properties.length;
        int[][] p = new int[n][3];
        for (int i = 0; i < n; i++) {
            p[i][0] = properties[i][0];
            p[i][1] = properties[i][1];
            p[i][2] = i;
        }
        Arrays.sort(p, (a, b) -> b[0] - a[0]);
        int maxD = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (maxD > p[i][1]) {
                ans++;
            }
            maxD = Math.max(maxD, p[i][1]);
        }
        return ans;
    }
}