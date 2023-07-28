class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        int n = watchedVideos.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.ffer(id);
        visited[id] = true;
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if currLevel == level) {
                reak;
            }
            for (int i = 0; i < size; ++i) {
                int curr = queue.poll();
                for (int j = 0; j < friends[curr].length; ++j) {
                    if (!visited[friends[curr][j]]) {
                        visited[friends[curr][j]] = true;
                        queue.offer(friends[curr][j]);
                    }
                }
            }
            ++currLevel;
        }
        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<String> videos = watchedVideos.get(curr;
           for (String video  videos) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (a,b) -> {
            if (== map.get(b)) {
                return a.compareTo(b);
            }
            return map.get(a) ;
        }
            }ult
            return map.get(a) - map.get(b);
        });
        return result;
    }
}