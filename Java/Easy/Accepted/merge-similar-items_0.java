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
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : map1.keySet()) {
            map.put(key, map1.get(key));
        }
        for (int key : map2.keySet()) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + map2.get(key));
            } else {
                map.put(key, map2.get(key));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(key);
            list.add(map.get(key));
            res.add(list);
        }
        res.sort((a, b) -> a.get(0) - b.get(0));
        return res;
    }
}