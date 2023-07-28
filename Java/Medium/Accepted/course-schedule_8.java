class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[1], x -> new ArrayList<>()).add(p[0]);
        }
        // build indegree
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
        }
        // bfs
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}