class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (!index.containsKey(num)) {
                index.put(num, new ArrayList<>());
            }
            index.get(num).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n - 1) {
                    return steps;
                }
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    queue.offer(curr - 1);
                    visited[curr - 1] = true;
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    queue.offer(curr + 1);
                    visited[curr + 1] = true;
                }
                int num = arr[curr];
                for (int next : index.get(num)) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                index.remove(num);
            }
            steps++;
        }
        return -1;
    }
}