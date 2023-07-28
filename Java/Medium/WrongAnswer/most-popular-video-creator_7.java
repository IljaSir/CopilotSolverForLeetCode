class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Integer> creatorMap = new HashMap<>();
        Map<String, Map<String, Integer>> videoMap = new HashMap<>();
        for (int i = 0; i < views.length; i++) {
            creatorMap.put(creators[i], creatorMap.getOrDefault(creators[i], 0) + views[i]);
            Map<String, Integer> video = videoMap.getOrDefault(creators[i], new HashMap<>());
            video.put(ids[i], video.getOrDefault(ids[i], 0) + views[i]);
            videoMap.put(creators[i], video);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : creatorMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : creatorMap.entrySet()) {
            if (entry.getValue() == max) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                int maxVideo = 0;
                for (Map.Entry<String, Integer> videoEntry : videoMap.get(entry.getKey()).entrySet()) {
                    maxVideo = Math.max(maxVideo, videoEntry.getValue());
                }
                String minId = null;
                for (Map.Entry<String, Integer> videoEntry : videoMap.get(entry.getKey()).entrySet()) {
                    if (videoEntry.getValue() == maxVideo) {
                        if (minId == null) {
                            minId = videoEntry.getKey();
                        } else {
                            minId = minId.compareTo(videoEntry.getKey()) < 0 ? minId : videoEntry.getKey();
                        }
                    }
                }
                list.add(minId);
                result.add(list);
            }
        }
        return result;
    }
}