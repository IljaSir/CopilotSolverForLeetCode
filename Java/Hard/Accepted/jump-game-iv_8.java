class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                if (u == n - 1) {
                    return step;
                }
                List<Integer> nexts = index.get(arr[u]);
                nexts.add(u - 1);
                nexts.add(u + 1);
                for (int v : nexts) {
                    if (v >= 0 && v < n && !visited[v]) {
                        q.offer(v);
                        visited[v] = true;
                    }
                }
                nexts.clear();
            }
            step++;
        }
        return -1;
    }
}