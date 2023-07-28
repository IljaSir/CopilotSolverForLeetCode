class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        
        int[] answer = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] l : logs) {
            map.putIfAbsent(l[0], new HashSet<>());
            map.get(l[0]).add(l[1]);
        }
        for (int key : map.keySet()) {
            int size = map.get(key).size();
            answer[size - 1] += 1;
        }
        return answer;
    }
}