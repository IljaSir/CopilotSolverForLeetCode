class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.computeIfAbsent(routes[i][j], x -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(source);
        visited.add(source);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int bus : graph.get(cur)) {
                    for (int next : routes[bus]) {
                        if (next == target) return step + 1;
                        if (visited.add(next)) q.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}