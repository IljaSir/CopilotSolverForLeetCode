class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            degree[edge.get(0) - 1]++;
            degree[edge.get(1) - 1]++;
            map.putIfAbsent(edge.get(0), new HashSet<>());
            map.putIfAbsent(edge.get(1), new HashSet<>());
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] % 2 == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (degree[cur] % 2 == 1) {
                for (int nei : map.get(cur + 1)) {
                    degree[nei - 1]--;
                    degree[cur]--;
                    map.get(nei).remove(cur + 1);
                    if (degree[nei - 1] % 2 == 1) {
                        queue.offer(nei - 1);
                    }
                }
            }
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}