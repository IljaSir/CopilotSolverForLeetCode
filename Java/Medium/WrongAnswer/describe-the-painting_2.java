class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        List<List<Long>> result = new ArrayList<>();
        long[] diff = new long[100001];
        for (int[] segment: segments) {
            diff[segment[0]] += segment[2];
            diff[segment[1]] -= segment[2];
        }
        long sum = 0;
        long start = 0;
        for (int i = 0; i < 100001; i++) {
            sum += diff[i];
            if (sum > 0 && start == 0) {
                start = i;
            } else if (sum == 0 && start > 0) {
                result.add(Arrays.asList(start, (long) i, sum));
                start = 0;
            }
        }
        return result;
    }
}