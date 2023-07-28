class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<String> path : paths) {
            int cur = 0;
            for (String s : path) {
                if (!map.containsKey(s)) {
                    map.put(s, map.size());
                    graph.put(map.get(s), new ArrayList<>());
                }
                int next = map.get(s);
                graph.get(cur).add(next);
                cur = next;
            }
        }
        int[] res = new int[graph.size()];
        Arrays.fill(res, -1);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                dfs(i, graph, res);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> path : paths) {
            int cur = 0;
            List<String> temp = new ArrayList<>();
            for (String s : path) {
                int next = map.get(s);
                if (res[next] == 0) {
                    temp.add(s);
                    cur = next;
                }
            }
            if (temp.size() > 0) {
                ans.add(temp);
            }
        }
        return ans;
    }

    private int dfs(int cur, Map<Integer, List<Integer>> graph, int[] res) {
        if (res[cur] != -1) {
            return res[cur];
        }
        res[cur] = 1;
        int[] count = new int[2];
        for (int next : graph.get(cur)) {
            count[dfs(next, graph, res)]++;
        }
        if (count[1] > 0) {
            res[cur] = 0;
        }
        return res[cur];
    }
}