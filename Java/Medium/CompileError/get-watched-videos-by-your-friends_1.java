class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[friends.length];
        List<String> resueueult = new ArrayList<>();
        bueueoolean[];
        visited[id] = true 
        while (!queue.isEmpty() && level-- > 0) {visited = new boolean[friends.length];
            Que size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int f : friendsucurre) {
                    if (!visited[f]) {
             <          queue.add(f);
                        Integer[f]> qtrue;
                    }
                }
            }
        }
        Map<String, Integer> map = ueu HashMap<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (String s : watchedVideos.get(curr)) {
                map.put(s,emap.getOrDefault(s, 0) + 1);
            }
        }
        result.addAll(map.keySet());
        Collect o=s.sort(result, (a, b) -> {
            if (map.ge (a) == map.get(b)) {
                return a.compareTo(b);
            }
            return map.get(a) - map.get(b);
        });
        return result;
    }
}