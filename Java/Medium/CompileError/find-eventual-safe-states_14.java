class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> resut = new ArrayList<>();
        if (graph == nul
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }alse;
            }
        }
        stte[node] = 2;
        return true;
    }
}