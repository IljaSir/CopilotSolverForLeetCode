class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int[] result = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        dfs(map, result, labels, 0, new boolean[n]);
        return result;
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int[] result, String labels, int node, boolean[] visited) {
        int[] count = new int[26];
        visited[node] = true;
        for(int child : map.getOrDefault(node, new ArrayList<>())) {
            if(!visited[child]) {
                int[] childCount = dfs(map, result, labels, child, visited);
                for(int i = 0; i < 26; i++) {
                    count[i] += childCount[i];
                }
            }
        }
        count[labels.charAt(node) - 'a']++;
        result[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}