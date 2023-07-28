class Solution {
    public long[] getDistances(int[] arr) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        long[] res = new long[arr.length];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    res[list.get(i)] += list.get(j) - list.get(i);
                    res[list.get(j)] += list.get(j) - list.get(i);
                }
            }
        }
        return res;
    }
}