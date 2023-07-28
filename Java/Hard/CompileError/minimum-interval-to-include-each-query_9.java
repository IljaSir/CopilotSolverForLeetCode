class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[] index = new int[m];
        for (int i = 0; i < m; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[a] - queries[b]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && intervals[j][0] <= queries[index[i]]) {
                pq.add(intervals[j]);
                j++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < queries[index[i]]) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                ans[index[i]] = -1;
            } else {
                ans[index[i]] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }
        return ans;
    }
}