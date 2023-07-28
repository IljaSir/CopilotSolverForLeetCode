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
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                res.add(Arrays.asList(key, map1.get(key) + map2.get(key)));
                map2.remove(key);
            }
        }
        for (int key : map1.keySet()) {
            res.add(Arrays.asList(key, map1.get(key)));
        }
        for (int key : map2.keySet()) {
            res.add(Arrays.asList(key, map2.get(key)));
        }
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }
}