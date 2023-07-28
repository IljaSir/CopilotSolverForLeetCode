class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (i == headID) {
                continue;
            }
            if (!map.containsKey(manager[i])) {
                map.put(manager[i], new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (map.containsKey(cur)) {
                    for (int next : map.get(cur)) {
                        queue.add(next);
                        informTime[next] += informTime[cur];
                    }
                }
            }
        }
        for (int time : informTime) {
            max = Math.max(max, time);
        }
        return max;
    }
}