class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] != course) {
                    continue;
                }
                inDegree[prerequisite[0]]--;
                if (inDegree[prerequisite[0]] == 0) {
                    queue.offer(prerequisite[0]);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
}