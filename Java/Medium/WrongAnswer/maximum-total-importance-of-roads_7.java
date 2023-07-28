class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        int[] used = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = i + 1;
        }
        Arrays.sort(val);
        int i = 0;
        long res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (used[cur] == 1) {
                continue;
            }
            used[cur] = 1;
            values.put(cur, val[i++]);
            for (int next : graph.get(cur)) {
                queue.add(next);
            }
        }
        for (int j = 0; j < roads.length; j++) {
            res += values.get(roads[j][0]) + values.get(roads[j][1]);
        }
        return res;
    }
}