class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        
        // build graph
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                graph.computeIfAbsent(firstEmail, x -> new ArrayList<>()).add(email);
                graph.computeIfAbsent(email, x -> new ArrayList<>()).add(firstEmail);
            }
        }
        
        // dfs
        for (String email : graph.keySet()) {
            if (visited.add(email)) {
                List<String> list = new ArrayList<>();
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                res.add(list);
            }
        }
        
        return res;
    }
    
    private void dfs(Map<String, List<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String nei : graph.get(email)) {
            if (visited.add(nei)) {
                dfs(graph, nei, visited, list);
            }
        }
    }
}