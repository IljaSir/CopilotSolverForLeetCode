class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> creatorToViews = new HashMap<>();
        Map<String, String> creatorToMaxId = new HashMap<>();
        Map<String, Integer> creatorToMaxViews = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            creatorToViews.put(creator, creatorToViews.getOrDefault(creator, 0) + view);
            if (creatorToMaxViews.getOrDefault(creator, 0) < view) {
                creatorToMaxViews.put(creator, view);
                creatorToMaxId.put(creator, id);
            } else if (creatorToMaxViews.getOrDefault(creator, 0) == view) {
                if (creatorToMaxId.get(creator).compareTo(id) > 0) {
                    creatorToMaxId.put(creator, id);
                }
            }
        }
        int maxViews = 0;
        for (String creator : creatorToViews.keySet()) {
            maxViews = Math.max(maxViews, creatorToViews.get(creator));
        }
        for (String creator : creatorToViews.keySet()) {
            if (creatorToViews.get(creator) == maxViews) {
                List<String> list = new ArrayList<>();
                list.add(creator);
                list.add(creatorToMaxId.get(creator));
                result.add(list);
            }
        }
        return result;
    }
}