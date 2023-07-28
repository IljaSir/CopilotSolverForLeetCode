class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] redEdge : redEdges) {
            int from = redEdge[0];
            int to = redEdge[1];
            List<Integer> list = redMap.getOrDefault(from, new ArrayList<>());
            list.add(to);
            redMap.put(from, list);
        }
        for (int[] blueEdge : blueEdges) {
            int from = blueEdge[0];
            int to = blueEdge[1];
            List<Integer> list = blueMap.getOrDefault(from, new ArrayList<>());
            list.add(to);
            blueMap.put(from, list);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int color = curr[1];
            int step = res[node];
            if (color == 0) {
                if (blueMap.containsKey(node)) {
                    for (int nextNode : blueMap.get(node)) {
                        if (res[nextNode] > step + 1) {
                            res[nextNode] = step + 1;
                            queue.offer(new int[]{nextNode, 1});
                        }
                    }
                }
            } else {
                if (redMap.containsKey(node)) {
                    for (int nextNode : redMap.get(node)) {
                        if (res[nextNode] > step + 1) {
                            res[nextNode] = step + 1;
                            queue.offer(new int[]{nextNode, 0});
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = res[i] == Integer.MAX_VALUE ? -1 : res[i];
        }
        return res;
    }
}