class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] result = new int[k];
        Map<Integer, Set<Integer>> userMap = new HashMap<>();
        for (int[] log : logs) {
            userMap.putIfAbsent(log[0], new HashSet<Integer>());
            userMap.get(log[0]).add(log[1]);
        }
        for (int key : userMap.keySet()) {
            result[userMap.get(key).size() - 1]++;
        }
        return result;
    }
}