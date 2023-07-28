class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        Map<Integer, Set<Integer>> redMap = new HashMap<>();
        Map<Integer, Set<Integer>> blueMap = new HashMap<>();
        for (int[] edge : redEdges) {
            redMap.putIfAbsent(edge[0], new HashSet<>());
            redMap.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueMap.putIfAbsent(edge[0], new HashSet<>());
            blueMap.get(edge[0]).add(edge[1]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        int step = 0;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[1] == 0) {
                    if (redMap.containsKey(cur[0])) {
                        for (int next : redMap.get(cur[0])) {
                            if (visited.contains(next + "1")) {
                                continue;
                            }
                            visited.add(next + "1");
                            queue.offer(new int[]{next, 1});
                            res[next] = Math.min(res[next], step);
                        }
                    }
                } else {
                    if (blueMap.containsKey(cur[0])) {
                        for (int next : blueMap.get(cur[0])) {
                            if (visited.contains(next + "0")) {
                                continue;
                            }
                            visited.add(next + "0");
                            queue.offer(new int[]{next, 0});
                            res[next] = Math.min(res[next], step);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
}