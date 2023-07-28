class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }
            map.get(id).add(time);
        }
        for (int id : map.keySet()) {
            int size = map.get(id).size();
            if (size <= k) {
                result[size - 1]++;
            }
        }
        return result;
    }
}