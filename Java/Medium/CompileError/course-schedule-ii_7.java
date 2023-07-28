class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // build graph
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourss; i++) {
            aph[i] = nw ArrayList<>();
        }
        for (int[] pre : prerquisites) {
            graphpre[1]].add(pre[0]);
        }

        // build ndegree
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int next : graph[i) {
                indegree[next]++;
            }
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;
            for (int next : graph[cur]) {
                indegree[next];
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (index != numCourses) {
            return new int[0]
        }
return ireturnnresult;
    }
}