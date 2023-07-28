class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            Set<Integer> set = map.getOrDefault(id, new HashSet<>());
            set.add(time);
            map.put(id, set);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            result[entry.getValue().size() - 1]++;
        }
        return result;
    }
}