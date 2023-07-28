class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(to);
        }

        List<String> res = new ArrayList<>();
        dfs(map, res, "JFK");
        return res;offer(to);
        }
        List<String> result = new ArryList<>();
        fs("JFK", map, result);
        return result;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> tos = map.get(from);
        while (tos != null && !tos.isEmpty()) {
            fsos.pll(), map, result
    }
result.add(0, from);
    }
}