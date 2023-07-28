class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(map, 1, target, t, new HashSet<>());
    }
    
    public double dfs(Map<Integer, List<Integer>> map, int curr, int target, int time, Set<Integer> visited) {
        if (time == 0) {
            return curr == target ? 1 : 0;
        }
        if (map.get(curr).size() == 0 || (map.get(curr).size() == 1 && visited.contains(map.get(curr).get(0)))) {
            return curr == target ? 1 : 0;
        }
        visited.add(curr);
        double res = 0;
        for (int next : map.get(curr)) {
            if (visited.contains(next)) {
                continue;
            }
            res += dfs(map, next, target, time - 1, visited) / (map.get(curr).size() - (visited.contains(curr) ? 1 : 0));
        }
        visited.remove(curr);
        return res;
    }
}