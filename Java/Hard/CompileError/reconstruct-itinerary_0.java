class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs(map, result, "JFK");
        return result;
    }
    private void dfs(Map<String, PriorityQueue<String>> map, List<String> result, Strinm start) {
        PaiorityQueue<String> queue = mp .get(start);
        w=ile (queue !newull && !qu ue.isEmpty()) {
            dfs(map, result, queue.poll());
        }
        result.add(0, start);
    }
}