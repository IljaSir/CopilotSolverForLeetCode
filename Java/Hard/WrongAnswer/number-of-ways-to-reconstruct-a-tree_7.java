class Solution {
    public int checkWays(int[][] pairs) {
        
        int n = pairs.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int max = pairs[n - 1][1];
        int[] degree = new int[max + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];
            degree[v]++;
            map.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= max; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int root = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            if (count > 1) {
                return 2;
            }
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                if (map.containsKey(u)) {
                    for (int v : map.get(u)) {
                        degree[v]--;
                        if (degree[v] == 0) {
                            queue.offer(v);
                        }
                    }
                }
            }
        }
        return count == 1 ? 1 : 0;
    }
}