class Solution {
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        
        int n = parents.length;
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (parents[i] != -1) {
                tree[parents[i]].add(i);
            }
        }
        int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a, b) -> a[1] - b[1]);
        int[] ans = new int[queries.length];
        int[] trie = new int[1 << 20];
        int[] cnt = new int[1 << 20];
        int idx = 1;
        for (int[] qq : q) {
            int node = qq[0], val = qq[1], id = qq[2];
            while (val > q[q.length - 1][1]) {
                int t = trie[node];
                if (t == 0) {
                    break;
                }
                node = t;
                val ^= node;
            }
            ans[id] = val;
            while (node != -1) {
                int t = trie[node];
                if (t == 0) {
                    trie[node] = idx;
                    node = -1;
                } else {
                    node = t;
                }
                cnt[node]++;
            }
        }
        return ans;
    }
}