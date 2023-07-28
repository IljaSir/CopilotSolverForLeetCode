class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int[] res = new int[queries.length];
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            while (index < intervals.length && intervals[index][1] <= queries[i]) {
                pq.offer(intervals[index]);
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < queries[i]) {
                pq.poll();
            }
            res[i] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return res;
    }
}