class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.offer(i);
        int[] res = new int[numCourses];
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[cnt++] = cur;
            for (int next : adj.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0)
                    q.offer(next);
            }
        }
        return cnt == numCourses ? res : new int[0];
    }
}