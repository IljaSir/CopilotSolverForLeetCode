class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> maxViews = new HashMap<>();
        Map<String, String> maxViewsId = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            map.put(creator, map.getOrDefault(creator, 0) + view);
            if (!maxViews.containsKey(creator) || maxViews.get(creator) < view) {
                maxViews.put(creator, view);
                maxViewsId.put(creator, id);
            } else if (maxViews.get(creator) == view && maxViewsId.get(creator).compareTo(id) > 0) {
                maxViewsId.put(creator, id);
            }
        }
        int maxPopularity = 0;
        for (int v : map.values()) {
            maxPopularity = Math.max(maxPopularity, v);
        }
        for (String creator : map.keySet()) {
            if (map.get(creator) == maxPopularity) {
                res.add(Arrays.asList(creator, maxViewsId.get(creator)));
            }
        }
        return res;
    }
}