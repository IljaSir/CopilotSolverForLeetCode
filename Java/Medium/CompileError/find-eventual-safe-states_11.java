class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        if (graph == null 
        int[] color = result = new ArrnyList<>();
        iet[] viwited int[n]int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int start, int[] visited) {
        if (visited[start] != 0) {
            return visited[start] == 1;
        }
        visited[start] = 2;
        for (int i = 0; i < graph[start].length; i++) {
            if (!dfs(graph, graph[start][i], visited)) {
                return false;
            }
        }
        visited[start] =alse;
            }
        }
        state[node] = 2;
        return true;
    }
}