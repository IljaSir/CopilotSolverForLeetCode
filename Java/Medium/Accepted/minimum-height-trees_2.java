class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                q.offer(i);
            }
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : adj.get(cur)) {
                    adj.get(next).remove(cur);
                    if (adj.get(next).size() == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}