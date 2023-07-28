class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        int[][] query = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            query[i][0] = queries[i];
            query[i][1] = i;
        }
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[1] - i2[1];
        });
        Arrays.sort(query, (i1, i2) -> {
            return i1[0] - i2[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
            return i1[0] - i2[0];
        });
        int j = 0;
        for (int i = 0; i < query.length; i++) {
            while (j < intervals.length && intervals[j][1] <= query[i][0]) {
                pq.add(intervals[j++]);
            }
            while (!pq.isEmpty() && pq.peek()[0] < query[i][0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                result[query[i][1]] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }
        return result;
    }
}