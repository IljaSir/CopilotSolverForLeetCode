class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String parent = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                graph.computeIfAbsent(parent, x -> new ArrayList<>()).add(account.get(i));
                graph.computeIfAbsent(account.get(i), x -> new ArrayList<>()).add(parent);
            }
            emailToName.put(parent, name);
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (visited.add(email)) {
                List<String> component = new ArrayList<>();
                dfs(graph, email, visited, component);
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }
    private void dfs(Map<String, List<String>> graph, String email, Set<String> visited, List<String> component) {
        component.add(email);
        for (String nei : graph.get(email)) {
            if (visited.add(nei)) {
                dfs(graph, nei, visited, component);
            }
        }
    }
}