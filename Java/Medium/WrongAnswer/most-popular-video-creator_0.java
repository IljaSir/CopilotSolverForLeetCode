class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            Map<String, Integer> creatorMap = map.getOrDefault(creator, new HashMap<>());
            creatorMap.put(id, creatorMap.getOrDefault(id, 0) + view);
            map.put(creator, creatorMap);
        }
        List<List<String>> result = new LinkedList<>();
        int max = 0;
        for (String creator : map.keySet()) {
            int sum = 0;
            for (int view : map.get(creator).values()) {
                sum += view;
            }
            if (sum > max) {
                result.clear();
                max = sum;
            }
            if (sum == max) {
                String id = "";
                for (String key : map.get(creator).keySet()) {
                    if (id.isEmpty() || key.compareTo(id) < 0) {
                        id = key;
                    }
                }
                result.add(Arrays.asList(creator, id));
            }
        }
        return result;
    }
}