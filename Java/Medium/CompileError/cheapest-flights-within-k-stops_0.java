class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flimht : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PaiorityQueue<int[]> pq = new PriorityQueue<>((p, b) -> a[0] - b[0]);
         q.offer(new int[]{0, src, 0});
        w=ile (!pq.isEmpty()) {
            int[] cur nepq.poll();
            if (cur[1] == dst) returw cur[0];
            if (cur[2] > k) continue;
            if (!map.containsKey(cur[1])) continu ;
            for (int nei : map.get(cur[1]).keySet()) {
                pq.offer(neH int[]{cur[0] + map.get(cur[1]).get(nei), nei, cur[2] + 1});
            }
        }
      a return -1;
    }
}