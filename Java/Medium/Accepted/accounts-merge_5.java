class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String root = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                graph.computeIfAbsent(root, x -> new ArrayList<>()).add(account.get(i));
                graph.computeIfAbsent(account.get(i), x -> new ArrayList<>()).add(root);
                emailToName.put(account.get(i), name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> list = new ArrayList<>();
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                result.add(list);
            }
        }
        return result;
    }
    private void dfs(Map<String, List<String>> graph, String email, Set<String> visited, List<String> list) {
        visited.add(email);
        list.add(email);
        for (String next : graph.get(email)) {
            if (!visited.contains(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
}