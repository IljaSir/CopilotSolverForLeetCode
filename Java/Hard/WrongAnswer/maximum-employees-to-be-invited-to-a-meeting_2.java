class Solution {
    public int maximumInvitations(int[] favorite) {
        
        int n = favorite.length;
        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int f = favorite[i];
            graph.get(f).add(i);
            degree[i]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans++;
            for (int v : graph.get(u)) {
                degree[v]--;
                if (degree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return ans;
    }
}