class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            map1.put(items1[i][0], items1[i][1]);
        }
        for (int i = 0; i < items2.length; i++) {
            map2.put(items2[i][0], items2[i][1]);
        }
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                result.add(Arrays.asList(key, map1.get(key) + map2.get(key)));
                map2.remove(key);
            } else {
                result.add(Arrays.asList(key, map1.get(key)));
            }
        }
        for (int key : map2.keySet()) {
            result.add(Arrays.asList(key, map2.get(key)));
        }
        return result;
    }
}