class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        Map<Integer, List<Integer>> groups = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> group = groups.getOrDefault(groupSizes[i], new ArrayList<>());
            group.add(i);
            if (group.size() == groupSizes[i]) {
                result.add(group);
                groups.remove(groupSizes[i]);
            } else {
                groups.put(groupSizes[i], group);
            }
        }
        return result;
    }
}