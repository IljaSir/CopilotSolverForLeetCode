class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] conn : connections) {
            map.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(conn[1]);
            map.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(-conn[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited.contains(cur)) continue;
            visited.add(cur);
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (next > 0) {
                        ans++;
                        queue.offer(next);
                    } else {
                        queue.offer(-next);
                    }
                }
            }
        }
        return ans;
    }
}