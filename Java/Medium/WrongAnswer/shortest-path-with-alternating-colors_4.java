class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] edge : redEdges) {
            redMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }
        int[] redDist = new int[n];
        int[] blueDist = new int[n];
        Arrays.fill(redDist, -1);
        Arrays.fill(blueDist, -1);
        redDist[0] = 0;
        blueDist[0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curNode = cur[0];
            int curColor = cur[1];
            if (curColor == 0) {
                if (blueMap.containsKey(curNode)) {
                    for (int next : blueMap.get(curNode)) {
                        if (blueDist[next] == -1) {
                            blueDist[next] = blueDist[curNode] + 1;
                            q.offer(new int[]{next, 1});
                        }
                    }
                }
            } else {
                if (redMap.containsKey(curNode)) {
                    for (int next : redMap.get(curNode)) {
                        if (redDist[next] == -1) {
                            redDist[next] = redDist[curNode] + 1;
                            q.offer(new int[]{next, 0});
                        }
                    }
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (redDist[i] == -1) {
                res[i] = blueDist[i];
            } else if (blueDist[i] == -1) {
                res[i] = redDist[i];
            } else {
                res[i] = Math.min(redDist[i], blueDist[i]);
            }
        }
        return res;
    }
}