class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                map.computeIfAbsent(routes[i][j], x -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                for (int bus : map.get(stop)) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int next : routes[bus]) {
                        if (next == target) return step + 1;
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}