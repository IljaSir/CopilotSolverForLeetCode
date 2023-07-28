class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            if (map.containsKey(node)) {
                for (int next : map.get(node)) {
                    indegree[next]--;
                    result.get(next).addAll(result.get(node));
                    result.get(next).add(node);
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return result;
    }
}