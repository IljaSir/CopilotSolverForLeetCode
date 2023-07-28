class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> pq = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            pq.add(ticket.get(1));
            map.put(ticket.get(0), pq);
        }
        List<String> res = new LinkedList<>();
        dfs(map, res, "JFK");
        return res;
    }
    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map, res, map.get(cur).poll());
        }
        res.add(0, cur);
    }
}