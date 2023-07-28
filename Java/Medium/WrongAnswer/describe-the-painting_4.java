class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        int n = segments.length;
        List<List<Long>> res = new ArrayList<>();
        long[] diff = new long[100001];
        for (int i = 0; i < n; i++) {
            diff[segments[i][0]] += segments[i][2];
            diff[segments[i][1]] -= segments[i][2];
        }
        long sum = 0, start = 0;
        for (int i = 0; i < 100001; i++) {
            if (diff[i] != 0) {
                if (sum != 0) {
                    res.add(Arrays.asList(start, (long)i, sum));
                }
                sum += diff[i];
                start = i;
            }
        }
        return res;
    }
}