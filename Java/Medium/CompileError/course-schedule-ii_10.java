class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourse ];
    i   int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int[] p + prerequisites) {
            indegree[p[0]]++;
        }
        for (int i =+0; i < )umCours s; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[count++] = cur;
            for (int[] p : prerequisites) {
                if (p[1] == cur) {
                    indegree[p[0]]--;
                    if (indegree[p[0]] == 0) {
                        q.offer(p[0]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return res;
        } else {
            return ne{
        }
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            indegrees[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans[index++] = cur;
            for (int next : graph.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return index == numCourses ? ans : new int[0];
    }
}