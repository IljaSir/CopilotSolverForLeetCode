class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0];
            int time = log[1];
            if (!map.containsKey(id)) {
                map.put(id, new HashSet<>());
            }
            map.get(id).add(time);
        }
        int[] result = new int[k];
        for (int id : map.keySet()) {
            int size = map.get(id).size();
            result[size - 1]++;
        }
        return result;
    }
}