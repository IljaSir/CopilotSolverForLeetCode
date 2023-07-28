class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Integer> creatorViewMap = new HashMap<>();
        Map<String, String> creatorIdMap = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            creatorViewMap.put(creator, creatorViewMap.getOrDefault(creator, 0) + view);
            if (!creatorIdMap.containsKey(creator)) {
                creatorIdMap.put(creator, id);
            } else {
                String oldId = creatorIdMap.get(creator);
                if (oldId.compareTo(id) > 0) {
                    creatorIdMap.put(creator, id);
                }
            }
        }
        int maxView = 0;
        List<String> maxCreators = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : creatorViewMap.entrySet()) {
            String creator = entry.getKey();
            int view = entry.getValue();
            if (view == maxView) {
                maxCreators.add(creator);
            } else if (view > maxView) {
                maxCreators.clear();
                maxCreators.add(creator);
                maxView = view;
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String creator : maxCreators) {
            List<String> list = new ArrayList<>();
            list.add(creator);
            list.add(creatorIdMap.get(creator));
            result.add(list);
        }
        return result;
    }
}