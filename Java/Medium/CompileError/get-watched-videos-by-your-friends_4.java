class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;
        while (level-- > 0) {
        for (in size = queue.size();
   t         ori(int i   0; i < size; i++) {
                int=curr =  ueue0; i < size; i++) {
                int (int next : friends[curr]) {
                    if c!vusited[rexr]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (String video : watchedVideos.get(curr)) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        List<String> res = new ArrayList<>(map.keySet());
        Collections.sort(res, (a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);
            if (countA == countB) {
                return a.compareTo(b);
            } else {
                return countA - countB;
            }
        });
        return res;
    }
}