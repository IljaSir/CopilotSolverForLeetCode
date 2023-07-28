class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int n = pairs.length;
        int[][] res = new int[n][2];
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        res[0] = pairs[0];
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] == res[j][1]) {
                res[++j] = pairs[i];
            } else {
                res[j + 1] = res[j];
                res[j--] = pairs[i];
            }
        }
        return res;
    }
}