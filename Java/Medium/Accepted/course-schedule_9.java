class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            graph.computeIfAbsent(p[1], x -> new ArrayList<>()).add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            if (graph.containsKey(curr)) {
                for (int i : graph.get(curr)) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) q.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}