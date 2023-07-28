class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek()[1] < interval[0]) {
                pq.poll();
            }
            pq.offer(interval);
            Integer key = map.ceilingKey(interval[0]);
            while (key != null && key <= interval[1]) {
                result[map.get(key)] = pq.peek()[1] - pq.peek()[0] + 1;
                map.remove(key);
                key = map.ceilingKey(interval[0]);
            }
        }
        return result;
    }
}