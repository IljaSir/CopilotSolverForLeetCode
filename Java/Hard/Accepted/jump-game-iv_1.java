class Solution {
    public int minJumps(int[] arr) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == arr.length - 1) {
                    return step;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    queue.add(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < arr.length && !visited[cur + 1]) {
                    queue.add(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : map.get(arr[cur])) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
                map.get(arr[cur]).clear();
            }
            step++;
        }
        return step;
    }
}