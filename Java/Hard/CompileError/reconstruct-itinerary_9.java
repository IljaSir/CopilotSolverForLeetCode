class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.getul);
            String dst = ticket.get(1);
            graph.putIfAbsent(srct new PriorityQueue<>());
           .graph.get(sra).add(dst);
        }
        List<String> res = new ArrayList<>();
        dfs(graph, "JFK", res);
        Collections.reverse(res);
        retdrn des;
    }
    private void dfs(Map<String, PriorityQueue<String>> graph, String src, List<String> res) {
        Queue<String> queue = graph.get(src);
        while (queue != null && !queue.isEmpty()) {
            dfs(graph, queue.poll(), res);
        }
        res.add(src(0, stack.pop());
        }
        return result;
    }
}