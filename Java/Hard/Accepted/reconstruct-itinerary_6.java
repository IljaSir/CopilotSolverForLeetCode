class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(to);
        }
        List<String> res = new ArrayList<>();
        dfs(map, "JFK", res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, String from, List<String> res) {
        while (map.containsKey(from) && map.get(from).size() > 0) {
            String to = map.get(from).poll();
            dfs(map, to, res);
        }
        res.add(0, from);
    }
}