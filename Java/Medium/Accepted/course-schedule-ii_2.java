class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
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