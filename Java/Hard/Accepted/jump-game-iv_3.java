class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) {
                    return step;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.add(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    queue.add(cur + 1);
                    visited[cur + 1] = true;
                }
                List<Integer> list = map.get(arr[cur]);
                for (int next : list) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
                list.clear();
            }
            step++;
        }
        return step;
    }
}