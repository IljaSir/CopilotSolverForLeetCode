class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] m : meetings) {
            map.get(m[0]).add(m[1]);
            map.get(m[1]).add(m[0]);
        }
        boolean[] visited = new boolean[n];
        visited[firstPerson] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(firstPerson);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                res.add(i);
            }
        }
        return res;
    }
}