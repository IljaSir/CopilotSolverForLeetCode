class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(parents[i], new ArrayList<>());
            map.get(parents[i]).add(i);
        }
        int[] cnt = new int[n];
        int[] score = new int[n];
        dfs(map, cnt, score, 0);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, score[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] == max) {
                res++;
            }
        }
        return res;
    }
    private void dfs(Map<Integer, List<Integer>> map, int[] cnt, int[] score, int node) {
        cnt[node] = 1;
        score[node] = 1;
        if (!map.containsKey(node)) {
            return;
        }
        for (int child : map.get(node)) {
            dfs(map, cnt, score, child);
            cnt[node] += cnt[child];
            score[node] *= score[child];
        }
        score[node] *= cnt[node];
    }
}