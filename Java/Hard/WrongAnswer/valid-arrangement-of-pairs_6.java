class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        int[][] res = new int[pairs.length][2];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int l = 0, r = pairs.length - 1;
        for (int i = 0; i < pairs.length; i++) {
            if (i % 2 == 0) {
                res[i] = pairs[l++];
            } else {
                res[i] = pairs[r--];
            }
        }
        return res;
    }
}