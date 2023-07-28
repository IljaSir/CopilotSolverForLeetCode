class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        int[][] adjacency = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int[] cp : prerequisites) {
            inDegree[cp[0]]++;
            adjacency[cp[1]][cp[0]] = 1;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int i = 0; i < adjacency.length; i++) {
                if (adjacency[pre][i] == 1) {
                    if (--inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}