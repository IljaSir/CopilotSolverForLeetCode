class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        for (int[] query : queries) {
            result.add(canFinish(numCourses, prerequisites, query[0], query[1]));
        }
        return result;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites, int start, int end) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (course == end) {
                return true;
            }
            visited[course] = true;
            for (int next : adj.get(course)) {
                if (!visited[next]) {
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}