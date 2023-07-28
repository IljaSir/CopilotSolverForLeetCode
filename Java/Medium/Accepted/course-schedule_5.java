class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int from = queue.poll();
            numCourses--;
            for (int[] edge : prerequisites) {
                if (edge[1] != from) {
                    continue;
                }
                if (--inDegree[edge[0]] == 0) {
                    queue.offer(edge[0]);
                }
            }
        }
        return numCourses == 0;
    }
}