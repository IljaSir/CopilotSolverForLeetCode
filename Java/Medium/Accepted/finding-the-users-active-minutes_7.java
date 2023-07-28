class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] result = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int user = log[0];
            int minute = log[1];
            if (!map.containsKey(user)) {
                map.put(user, new HashSet<>());
            }
            map.get(user).add(minute);
        }
        for (Integer user : map.keySet()) {
            int size = map.get(user).size();
            result[size - 1]++;
        }
        return result;
    }
}