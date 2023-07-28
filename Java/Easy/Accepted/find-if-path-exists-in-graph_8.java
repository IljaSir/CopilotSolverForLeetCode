class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        if (n == 1) {
            return true;
        }
        if (edges.length == 0) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(source);
        visited.add(source);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == destination) {
                    return true;
                }
                if (map.containsKey(node)) {
                    for (int next : map.get(node)) {
                        if (!visited.contains(next)) {
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return false;
    }
}