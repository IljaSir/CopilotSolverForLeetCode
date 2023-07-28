class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        dfs(0, -1, map, labels, ans);
        return ans;
    }

    private int[] dfs(int cur, int pre, Map<Integer, List<Integer>> map, String labels, int[] ans) {
        int[] count = new int[26];
        count[labels.charAt(cur) - 'a']++;
        if (map.containsKey(cur)) {
            for (int next : map.get(cur)) {
                if (next == pre) {
                    continue;
                }
                int[] subCount = dfs(next, cur, map, labels, ans);
                for (int i = 0; i < 26; i++) {
                    count[i] += subCount[i];
                }
            }
        }
        ans[cur] = count[labels.charAt(cur) - 'a'];
        return count;
    }
}