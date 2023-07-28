class Solution {
    public int[][] validArrangement(int[][] pairs) {
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int[][] res = new int[pairs.length][2];
        int i = 0;
        for (int[] pair : pairs) {
            if (i == 0) {
                res[i] = pair;
            } else {
                int[] last = res[i - 1];
                if (last[1] == pair[0]) {
                    res[i] = pair;
                } else {
                    res[i] = new int[]{pair[1], pair[0]};
                }
            }
            i++;
        }
        return res;
    }
}