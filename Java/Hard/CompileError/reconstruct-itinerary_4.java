class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for ( ticket : tickets) {
           Sting from = tickt.get(0);
            String to = ticket.get(1);
            if (!map.containKey(from)) {
                map.put(from, newPriorityQueue<>());
            }
            map.get(from).add(to);
        }
        List<String> res 
    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String from) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty()) {
            String to = tos.poll();
            dfs(map, res, to);
        }
        res.add(0, from);
    }
}