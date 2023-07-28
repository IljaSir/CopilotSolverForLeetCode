class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        // build a graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        // add restrictions
        for (int[] restriction : restrictions) {
            graph.get(restriction[0]).add(restriction[1]);
            graph.get(restriction[1]).add(restriction[0]);
        }
        // process requests
        for (int i = 0; i < requests.length; i++) {
            int[] request = requests[i];
            if (graph.get(request[0]).contains(request[1])) {
                result[i] = false;
                continue;
            }
            Set<Integer> visited = new HashSet<>();
            visited.add(request[0]);
            result[i] = dfs(request[0], request[1], graph, visited);
        }
        return result;
    }
    
    private boolean dfs(int start, int end, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if (graph.get(start).contains(end)) {
            return false;
        }
        for (int next : graph.get(start)) {
            if (visited.contains(next)) {
                continue;
            }
            visited.add(next);
            if (!dfs(next, end, graph, visited)) {
                return false;
            }
        }
        return true;
    }
}