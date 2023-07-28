class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            if (list.size() == groupSizes[i]) {
                result.add(list);
                map.remove(groupSizes[i]);
            } else {
                map.put(groupSizes[i], list);
            }
        }
        return result;
    }
}