class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], (a) -> new HashMap<>()).put(flight[1], flight[2]);
        }
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {src, 0, k + 1});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int city = info[0];
            int price = info[1];
            int stop = info[2];
            if (city == dst) {
                return price;
            }
            if (stop > 0) {
                Map<Integer, Integer> next = graph.getOrDefault(city, new HashMap<>());
                for (int nextCity : next.keySet()) {
                    queue.add(new int[] {nextCity, price + next.get(nextCity), stop - 1});
                }
            }
        }
        return -1;
    }
}