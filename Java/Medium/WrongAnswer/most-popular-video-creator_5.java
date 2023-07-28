class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> creatorPopularity = new HashMap<>();
        Map<String, Map<String, Integer>> creatorVideoPopularity = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            creatorPopularity.put(creator, creatorPopularity.getOrDefault(creator, 0) + view);
            Map<String, Integer> videoPopularity = creatorVideoPopularity.getOrDefault(creator, new HashMap<>());
            videoPopularity.put(id, videoPopularity.getOrDefault(id, 0) + view);
            creatorVideoPopularity.put(creator, videoPopularity);
        }
        int maxPopularity = 0;
        for (int popularity : creatorPopularity.values()) {
            maxPopularity = Math.max(maxPopularity, popularity);
        }
        for (Map.Entry<String, Integer> entry : creatorPopularity.entrySet()) {
            if (entry.getValue() == maxPopularity) {
                Map<String, Integer> videoPopularity = creatorVideoPopularity.get(entry.getKey());
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                int maxView = 0;
                for (int view : videoPopularity.values()) {
                    maxView = Math.max(maxView, view);
                }
                for (Map.Entry<String, Integer> videoEntry : videoPopularity.entrySet()) {
                    if (videoEntry.getValue() == maxView) {
                        list.add(videoEntry.getKey());
                        break;
                    }
                }
                result.add(list);
            }
        }
        return result;
    }
}