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
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                res.add(curr);
                for (int neighbor : adj.get(curr)) {
                    adj.get(neighbor).remove(curr);
                    if (adj.get(neighbor).size() == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}