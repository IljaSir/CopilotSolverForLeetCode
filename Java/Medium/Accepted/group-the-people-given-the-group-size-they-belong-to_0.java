class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (map.containsKey(size)) {
                map.get(size).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(size, list);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int size = entry.getKey();
            for (int i = 0; i < list.size(); i += size) {
                List<Integer> subList = list.subList(i, i + size);
                result.add(subList);
            }
        }
        return result;
    }
}