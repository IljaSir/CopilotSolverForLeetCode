class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0], new HashSet<>());
            set.add(log[1]);
            map.put(log[0], set);
        }
        for (int key : map.keySet()) {
            res[map.get(key).size() - 1]++;
        }
        return res;
    }
}