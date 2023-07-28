class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        if (n == 1) {
            return true;
        }
        if (edges.size() == 0) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(b);
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            degree[i] = map.get(i).size();
        }
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd != 2) {
            return false;
        }
        int start = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                start = i;
                break;
            }
        }
        Set<Integer> visited = new HashSet<>();
        if (!dfs(start, map, degree, visited)) {
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int start, Map<Integer, List<Integer>> map, int[] degree, Set<Integer> visited) {
        visited.add(start);
        for (int next : map.get(start)) {
            if (degree[next] % 2 == 1) {
                if (visited.contains(next)) {
                    return false;
                }
                if (!dfs(next, map, degree, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}