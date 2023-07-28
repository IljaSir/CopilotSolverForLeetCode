class Solution {
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] c : connections) {
            int x = c[0], y = c[1];
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(-x);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int res = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            for (int y : map.getOrDefault(x, new ArrayList<>())) {
                if (y > 0 && !visited[y]) {
                    q.add(y);
                } else if (y < 0 && !visited[-y]) {
                    q.add(-y);
                    res++;
                }
            }
        }
        return res;
    }
}