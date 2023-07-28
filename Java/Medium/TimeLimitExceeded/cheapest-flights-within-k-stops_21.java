class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.computeIfAbsent(from, (key) -> new HashMap<>()).put(to, price);
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.add(new int[]{0, src, k + 1});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int price = info[0], city = info[1], stops = info[2];
            if (city == dst) {
                return price;
            }
            if (stops > 0) {
                Map<Integer, Integer> adj = graph.getOrDefault(city, new HashMap<>());
                for (int next : adj.keySet()) {
                    queue.add(new int[]{price + adj.get(next), next, stops - 1});
                }
            }
        }
        return -1;
    }
}