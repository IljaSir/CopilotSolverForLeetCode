class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        Map<Integer, Set<Integer>> langSet = new HashMap<>();
        for (int i = 0; i < m; i++) {
            langSet.put(i, new HashSet<>());
            for (int lang : languages[i]) {
                langSet.get(i).add(lang);
            }
        }
        Map<Integer, Set<Integer>> friendSet = new HashMap<>();
        for (int[] fr : friendships) {
            int u = fr[0] - 1;
            int v = fr[1] - 1;
            if (langSet.get(u).equals(langSet.get(v))) {
                continue;
            }
            friendSet.putIfAbsent(u, new HashSet<>());
            friendSet.putIfAbsent(v, new HashSet<>());
            friendSet.get(u).add(v);
            friendSet.get(v).add(u);
        }
        int ans = m;
        for (int lang = 1; lang <= n; lang++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (langSet.get(i).contains(lang)) {
                    set.add(i);
                }
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (set.contains(i)) {
                    continue;
                }
                if (friendSet.get(i) != null) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}