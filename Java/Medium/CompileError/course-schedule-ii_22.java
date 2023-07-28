class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // build graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        // build indegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int next : graph[i]) {
                indegree[next]++;
            }
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
       fo (int i = 0; i < numCours; i++) {
            if (indegree[i] == 0) {
               queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;
            for (int next  graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                   queue.offer(xt);
                }
            }
        }

        if (index != numCourses) {
            return ne;
        }
        return result
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[index++] = cur;
            for (int[] p : prerequisites) {
                if (p[1] == cur) {
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) {
                        q.offer(p[0]);
                    }
                }
            }
        }
        if (index == numCourses) {
            return res;
        }
        return new int[0];
    }
}