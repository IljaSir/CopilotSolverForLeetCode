class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.removeFirst();
                if (idx == n - 1) {
                    return steps;
                }
                List<Integer> list = map.get(arr[idx]);
                for (int j : list) {
                    if (!visited[j]) {
                        q.addLast(j);
                        visited[j] = true;
                    }
                }
                list.clear();
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    q.addLast(idx - 1);
                    visited[idx - 1] = true;
                }
                if (idx + 1 < n && !visited[idx + 1]) {
                    q.addLast(idx + 1);
                    visited[idx + 1] = true;
                }
            }
            steps++;
        }
        return steps;
    }
}