class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            List<Integer> list = map.get(course);
            if (list != null) {
                for (int i : list) {
                    inDegree[i]--;
                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}