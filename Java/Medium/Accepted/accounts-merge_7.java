class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                map.computeIfAbsent(account.get(i), x -> new ArrayList<>()).add(account.get(1));
                map.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(account.get(i));
                name.put(account.get(i), userName);
            }
        }
        Set<String> visited = new HashSet<>();
        for (String email : map.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> list = new ArrayList<>();
                list.add(email);
                dfs(map, visited, list, email);
                Collections.sort(list);
                list.add(0, name.get(email));
                result.add(list);
            }
        }
        return result;
    }
    private void dfs(Map<String, List<String>> map, Set<String> visited, List<String> list, String email) {
        for (String next : map.get(email)) {
            if (!visited.contains(next)) {
                visited.add(next);
                list.add(next);
                dfs(map, visited, list, next);
            }
        }
    }
}