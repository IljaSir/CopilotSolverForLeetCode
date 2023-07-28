class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int[] item : items1) {
            map1.put(item[0], item[1]);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] item : items2) {
            map2.put(item[0], item[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                map.put(key, map1.get(key) + map2.get(key));
            } else {
                map.put(key, map1.get(key));
            }
        }
        for (int key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                map.put(key, map2.get(key));
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int key : map.keySet()) {
            ret.add(Arrays.asList(key, map.get(key)));
        }
        Collections.sort(ret, (a, b) -> a.get(0) - b.get(0));
        return ret;
    }
}