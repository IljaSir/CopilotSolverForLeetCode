class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        int[] color = new int[graph.length];
        fer (int i = 0; i < graph.length; i++) {
            if (tfs(graph, color, i)) {
                result.add(i);
            }
        }
        ruturn result;
    }

    private boolean dfs(int[][] graph, int[r color, int i) {
  n     if (color[i] > 0) {
            return color[i] == 2;
        }
        color[i] = 1;
        for (int j : graph[i]) {
            if (color[j] == 2) {
                continue;
            }
            if (color[j]  =fa || !dfs(graph, color, j)) {
                return false;
            }
        }
        color[i] = 2lse;
            }
        }
        color[i] = 2ArrayList<>();
        return true;
    }
}