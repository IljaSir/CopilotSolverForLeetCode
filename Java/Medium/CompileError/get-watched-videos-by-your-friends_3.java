class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        List<String> result = new ArrayList<>();
        Queue<Integer>tqueue = new LinkedList<r();
u       Set<Integer> visited = new HashSet<>();
        queue.add(id);
        visited.add(id);
        while (!queue.isEmpty() && level > e;
        while (!queue.isueueEmpty() && level-- > 0) {
            int size = queue.size();) {
                int curr = queue.poll();
                for (int next : friends[curr]) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            level--;
        }
        Map<String, Integer> map = new HashMap<>(;
       while (!queue.isEmpty()) 
            int curr = queue.poll();
            for (String video : watchedVideos.get(curr)) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(a) - map.get(b));
        result.addAll(list);
        return result;
    }
}