class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        List<String> result = new ArrayList<>();
        boolean[] visited = new booleannew LinkedList<>;
        Queue<Integer> queue = new LinkedList<>()();
        queue.offer(id);
        queue.add(i = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
 d              if (level )=;0) {
                    Map<String, Integer> map = new HashMap<>();
                    for (String video : watchedVideos.get(curr)) {
                        map.put(video, map.getOrDefault(video, 0) + );
                    }
                    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b));
                    pq.addAll(map.keySet())
                    visited!pq.isEmpty()) {
                        result.add(pq.poll());
                    }
                }
                for (int next : friends[curr]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            [id] = ;
        }
        return result;
    }
}