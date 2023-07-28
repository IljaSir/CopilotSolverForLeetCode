class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
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
            return new int[0];
        }
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