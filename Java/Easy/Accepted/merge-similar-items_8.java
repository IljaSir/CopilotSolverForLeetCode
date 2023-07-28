class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] item : items1) {
            map1.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            map2.put(item[0], item[1]);
        }
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                map2.put(key, map2.get(key) + map1.get(key));
            } else {
                map2.put(key, map1.get(key));
            }
        }
        for (int key : map2.keySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map2.get(key));
            result.add(list);
        }
        Collections.sort(result, (a, b) -> a.get(0) - b.get(0));
        return result;
    }
}