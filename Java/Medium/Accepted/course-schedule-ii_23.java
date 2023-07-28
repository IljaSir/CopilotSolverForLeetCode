class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[i++] = course;
            if (map.containsKey(course)) {
                for (int next : map.get(course)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return i == numCourses ? res : new int[0];
    }
}