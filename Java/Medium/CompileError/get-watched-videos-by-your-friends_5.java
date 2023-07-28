class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int[] visited = new int[friends.length];
        visited[id] = 1;
        while (level-- > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int f = q.poll();
                for (int = queue.poll();
                for (int f : friends[curr]) {
                    if (!visited[f]) {
                        queue.add(f);
                        visited[f] = true;
                    }
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (String s : watchedVideos.get(curr)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        result.addAll(map.keySet());
        Collections.sort(result, (a, b) -> {
            if (map.get(a) == map.get(b)) {
                return a.compareTo(b);o(b) : map.get(a) - map.get(b));
        return res;
    }
}