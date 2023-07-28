class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                for (int j : list) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
                list.add(i);
                rec.put(site, list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for (int bus : rec.getOrDefault(source, new ArrayList<>())) {
            queue.offer(bus);
            vis[bus] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i > 0; i--) {
                int x = queue.poll();
                for (int y : graph.get(x)) {
                    if (vis[y]) {
                        continue;
                    }
                    if (rec.containsKey(target) && rec.get(target).contains(y)) {
                        return res;
                    }
                    queue.offer(y);
                    vis[y] = true;
                }
            }
        }
        return -1;
    }
}