class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(res, "JFK", graph);
        return res;
    }
    
    private void dfs(List<String> res, String cur, Map<String, PriorityQueue<String>> graph) {
        while (graph.containsKey(cur) && !graph.get(cur).isEmpty()) {
            dfs(res, graph.get(cur).poll(), graph);
        }
        res.add(0, cur);
    }
}