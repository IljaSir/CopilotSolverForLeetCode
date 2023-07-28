class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        if (numCourses == 0) {
            return result;
        }
        Set<Integer>[] graph = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (i == j) {
                    continue;
                }
                if (graph[i].contains(j)) {
                    continue;
                }
                for (int k : graph[j]) {
                    if (graph[i].contains(k)) {
                        graph[i].add(j);
                        break;
                    }
                }
            }
        }
        for (int[] query : queries) {
            result.add(graph[query[0]].contains(query[1]));
        }
        return result;
    }
}