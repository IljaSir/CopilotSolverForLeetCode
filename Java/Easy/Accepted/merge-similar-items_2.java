class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] item : items1) {
            map1.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            map2.put(item[0], item[1]);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int value = entry.getKey();
            int weight = entry.getValue();
            if (map2.containsKey(value)) {
                weight += map2.get(value);
                map2.remove(value);
            }
            ret.add(Arrays.asList(value, weight));
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            ret.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        ret.sort((a, b) -> a.get(0) - b.get(0));
        return ret;
    }
}