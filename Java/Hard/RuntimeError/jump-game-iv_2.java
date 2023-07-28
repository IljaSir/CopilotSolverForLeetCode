class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n - 1) {
                    return step;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    q.offer(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    q.offer(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : map.get(arr[cur])) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }
                map.remove(arr[cur]);
            }
            step++;
        }
        return step;
    }
}