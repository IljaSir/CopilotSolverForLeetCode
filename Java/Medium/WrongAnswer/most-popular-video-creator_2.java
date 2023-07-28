class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            if (!map.containsKey(creator)) {
                map.put(creator, new HashMap<>());
            }
            map.get(creator).put(id, view + map.get(creator).getOrDefault(id, 0));
        }
        int max = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            int total = 0;
            for (int value : entry.getValue().values()) {
                total += value;
            }
            max = Math.max(max, total);
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            int total = 0;
            for (int value : entry.getValue().values()) {
                total += value;
            }
            if (total == max) {
                String maxId = "";
                int maxView = 0;
                for (Map.Entry<String, Integer> e : entry.getValue().entrySet()) {
                    if (e.getValue() > maxView) {
                        maxId = e.getKey();
                        maxView = e.getValue();
                    }
                }
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.add(maxId);
                result.add(list);
            }
        }
        return result;
    }
}