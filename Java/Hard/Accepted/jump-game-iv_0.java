class Solution {
    public int minJumps(int[] arr) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        int[] dist = new int[arr.length];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (u == arr.length - 1) {
                break;
            }
            if (u - 1 >= 0 && dist[u - 1] == -1) {
                dist[u - 1] = dist[u] + 1;
                queue.offer(u - 1);
            }
            if (u + 1 < arr.length && dist[u + 1] == -1) {
                dist[u + 1] = dist[u] + 1;
                queue.offer(u + 1);
            }
            for (int v : map.get(arr[u])) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
            map.get(arr[u]).clear();
        }
        return dist[arr.length - 1];
    }
}