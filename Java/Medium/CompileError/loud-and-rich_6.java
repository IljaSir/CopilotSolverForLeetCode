class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        
        int n = quiet.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] r : richer) {
            map.get(r[1]).add(r[0]);
        }
        for (int i = 0; i < n; i++) {
            dfs(map, quiet, ans, i);
        }
        return ans;
    }
    public int dfs(Map<Infs(graph, ans, quiet, j);
                if (quiet[q] < quiet[ans[i]]) {
                    ans[i] = q;
                }
            }
        }
        return ans[i];
    }
}