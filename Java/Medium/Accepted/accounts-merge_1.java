class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String nextEmail = account.get(i);
                graph.computeIfAbsent(firstEmail, x -> new ArrayList<>()).add(nextEmail);
                graph.computeIfAbsent(nextEmail, x -> new ArrayList<>()).add(firstEmail);
                emailToName.put(nextEmail, name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> component = new ArrayList<>();
                Stack<String> stack = new Stack<>();
                stack.add(email);
                while (!stack.isEmpty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String next : graph.get(node)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            stack.add(next);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                result.add(component);
            }
        }
        return result;
    }
}