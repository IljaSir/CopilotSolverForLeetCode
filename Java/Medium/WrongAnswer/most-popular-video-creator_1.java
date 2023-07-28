class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            if (!map.containsKey(creators[i])) {
                map.put(creators[i], new HashMap<>());
            }
            Map<String, Integer> temp = map.get(creators[i]);
            temp.put(ids[i], temp.getOrDefault(ids[i], 0) + views[i]);
        }
        String max = "";
        int maxCount = 0;
        for (String creator : map.keySet()) {
            int count = 0;
            for (String id : map.get(creator).keySet()) {
                count += map.get(creator).get(id);
            }
            if (count > maxCount || (count == maxCount && creator.compareTo(max) < 0)) {
                max = creator;
                maxCount = count;
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(max);
        temp.add(findMax(map.get(max)));
        res.add(temp);
        return res;
    }
    
    private String findMax(Map<String, Integer> map) {
        String max = "";
        int maxCount = 0;
        for (String id : map.keySet()) {
            if (map.get(id) > maxCount || (map.get(id) == maxCount && id.compareTo(max) < 0)) {
                max = id;
                maxCount = map.get(id);
            }
        }
        return max;
    }
}