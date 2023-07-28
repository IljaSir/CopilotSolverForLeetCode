class Solution {
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] con : connections) {
            map.get(con[0]).add(con[1]);
            map.get(con[1]).add(-con[0]);
        }
        int ret = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : map.get(cur)) {
                if (next > 0) {
                    if (visited.add(next)) {
                        q.add(next);
                        ret++;
                    }
                } else {
                    if (visited.add(-next)) {
                        q.add(-next);
                    }
                }
            }
        }
        return ret;
    }
}