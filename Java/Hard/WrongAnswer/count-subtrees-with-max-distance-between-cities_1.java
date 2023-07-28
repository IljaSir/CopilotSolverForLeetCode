class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] ans = new int[n - 1];
        for (int i = 1; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(j);
                }
            }
            if (list.size() <= 1) {
                continue;
            }
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            dist[list.get(0)] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(list.get(0));
            boolean flag = true;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int[] edge : edges) {
                    int next = 0;
                    if (edge[0] == cur + 1) {
                        next = edge[1] - 1;
                    } else if (edge[1] == cur + 1) {
                        next = edge[0] - 1;
                    } else {
                        continue;
                    }
                    if (!list.contains(next)) {
                        continue;
                    }
                    if (dist[next] != -1) {
                        continue;
                    }
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
            for (int j = 0; j < n; j++) {
                if (!list.contains(j)) {
                    continue;
                }
                if (dist[j] == -1) {
                    flag = false;
                }
            }
            if (!flag) {
                continue;
            }
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (!list.contains(j)) {
                    continue;
                }
                max = Math.max(max, dist[j]);
            }
            ans[max - 1]++;
        }
        return ans;
    }
}