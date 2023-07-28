class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        int n = segments.length;
        int[] diff = new int[100001];
        for (int[] seg : segments) {
            diff[seg[0]] += seg[2];
            diff[seg[1]] -= seg[2];
        }
        List<List<Long>> res = new ArrayList<>();
        long sum = 0, start = 0;
        for (int i = 0; i < 100001; i++) {
            if (sum > 0) {
                res.add(Arrays.asList(start, (long) i, sum));
            }
            sum += diff[i];
            start = i;
        }
        return res;
    }
}