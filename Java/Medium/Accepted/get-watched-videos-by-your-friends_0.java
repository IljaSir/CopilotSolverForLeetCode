class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited.add(id);
        for (int i = 0; i < level; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int curr = queue.poll();
                for (int f : friends[curr]) {
                    if (visited.contains(f)) {
                        continue;
                    }
                    queue.add(f);
                    visited.add(f);
                }
            }
        }
        Map<String, Integer> count = new HashMap<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (String s : watchedVideos.get(curr)) {
                count.put(s, count.getOrDefault(s, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>(count.keySet());
        Collections.sort(res, (a, b) -> count.get(a) == count.get(b) ? a.compareTo(b) : count.get(a) - count.get(b));
        return res;
    }
}