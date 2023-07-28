class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        int[][] graph = new int[keys.size()][keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i; j < keys.size(); j++) {
                int sum = keys.get(i) + keys.get(j);
                if (Math.sqrt(sum) % 1 == 0) {
                    graph[i][j] = graph[j][i] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < keys.size(); i++) {
            ans += dfs(graph, keys, count, i, n - 1);
        }
        return ans;
    }

    private int dfs(int[][] graph, List<Integer> keys, Map<Integer, Integer> count, int i, int n) {
        count.put(keys.get(i), count.get(keys.get(i)) - 1);
        int ans = 0;
        if (n == 0) {
            ans = 1;
        } else {
            for (int j = 0; j < keys.size(); j++) {
                if (graph[i][j] == 1 && count.get(keys.get(j)) > 0) {
                    ans += dfs(graph, keys, count, j, n - 1);
                }
            }
        }
        count.put(keys.get(i), count.get(keys.get(i)) + 1);
        return ans;
    }
}