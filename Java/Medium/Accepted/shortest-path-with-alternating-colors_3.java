class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] edge : redEdges) {
            redMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        int step = 0;
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 0);
        visited.add(0 + " " + 1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int color = node[1];
                int nextColor = color == 0 ? 1 : 0;
                Map<Integer, List<Integer>> map = color == 0 ? redMap : blueMap;
                if (map.containsKey(node[0])) {
                    for (int next : map.get(node[0])) {
                        if (result[next] == -1) {
                            result[next] = step;
                        }
                        if (!visited.contains(next + " " + nextColor)) {
                            visited.add(next + " " + nextColor);
                            queue.offer(new int[]{next, nextColor});
                        }
                    }
                }
            }
        }
        return result;
    }
}