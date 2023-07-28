class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Integer> creatorToViews = new HashMap<>();
        Map<String, Map<String, Integer>> creatorToIdToViews = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            creatorToViews.put(creator, creatorToViews.getOrDefault(creator, 0) + views[i]);
            creatorToIdToViews.putIfAbsent(creator, new HashMap<>());
            creatorToIdToViews.get(creator).put(id, creatorToIdToViews.get(creator).getOrDefault(id, 0) + views[i]);
        }
        int maxViews = 0;
        for (int views : creatorToViews.values()) {
            maxViews = Math.max(maxViews, views);
        }
        List<List<String>> result = new ArrayList<>();
        for (String creator : creatorToViews.keySet()) {
            if (creatorToViews.get(creator) == maxViews) {
                Map<String, Integer> idToViews = creatorToIdToViews.get(creator);
                int maxIdViews = 0;
                for (int views : idToViews.values()) {
                    maxIdViews = Math.max(maxIdViews, views);
                }
                List<String> pair = new ArrayList<>();
                pair.add(creator);
                for (String id : idToViews.keySet()) {
                    if (idToViews.get(id) == maxIdViews) {
                        pair.add(id);
                        break;
                    }
                }
                result.add(pair);
            }
        }
        return result;
    }
}