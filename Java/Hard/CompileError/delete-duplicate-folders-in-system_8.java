class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] cnt = new int[1];
        for (List<String> path : paths) {
            int cur = 0;
            for (String s : path) {
                if (!graph.containsKey(cur)) {
                    graph.put(cur, new ArrayList<>());
                }
                if (!map.containsKey(s)) {
                    map.put(s, cnt[0]);
                    cnt[0]++;
                }
                graph.get(cur).add(map.get(s));
                cur = map.get(s);
            }
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> deleted = new HashSet<>();
        dfs(0, graph, visited, deleted);
        Map<Integer, List<String>> pathMap = new HashMap<>();
        for (String s : map.keySet()) {
            int cur = map.get(s);
            if (!deleted.contains(cur)) {
                List<String> path = new ArrayList<>();
                while (cur != 0) {
                    for (int i : map.keySet()) {
                        if (map.get(i) == cur) {
                            path.add(0, i);
                            break;
                        }
                    }
                    for (int i : graph.keySet()) {
                        if (graph.get(i).contains(cur)) {
                            cur = i;
                            break;
                        }
                    }
                }
                pathMap.put(cur, path);
            }
        }
        for (int i : pathMap.keySet()) {
            ans.add(pathMap.get(i));
        }
        return ans;
    }

    private void dfs(int cur, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> deleted) {
        if (visited.contains(cur)) {
            deleted.add(cur);
            return;
        }
        visited.add(cur);
        if (graph.containsKey(cur)) {
            for (int i : graph.get(cur)) {
                dfs(i, graph, visited, deleted);
            }
        }
        visited.remove(cur);
    }
}