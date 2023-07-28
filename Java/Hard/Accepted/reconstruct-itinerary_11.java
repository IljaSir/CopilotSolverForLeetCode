class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            graph.putIfAbsent(src, new PriorityQueue<>());
            graph.get(src).add(dst);
        }
        List<String> res = new ArrayList<>();
        dfs(graph, "JFK", res);
        Collections.reverse(res);
        return res;
    }
    private void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> res) {
        Queue<String> queue = graph.get(src);
        while (queue != null && !queue.isEmpty()) {
            dfs(graph, queue.poll(), res);
        }
        res.add(src);
    }
}