class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int site : routes[i]) {
                List<Integer> list = rec.getOrDefault(site, new ArrayList<>());
                list.add(i);
                rec.put(site, list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        boolean[] vis = new boolean[n];
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int site = queue.poll();
                for (int bus : rec.get(site)) {
                    if (vis[bus]) {
                        continue;
                    }
                    vis[bus] = true;
                    for (int s : routes[bus]) {
                        if (s == target) {
                            return step + 1;
                        }
                        queue.offer(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}