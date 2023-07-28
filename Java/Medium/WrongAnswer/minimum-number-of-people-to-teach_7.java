class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        int[] langCount = new int[n + 1];
        for (int[] lang : languages) {
            for (int l : lang) {
                langCount[l]++;
            }
        }
        Map<Integer, Set<Integer>> langToUsers = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int l : languages[i]) {
                langToUsers.computeIfAbsent(l, k -> new HashSet<>()).add(i);
            }
        }
        int min = m;
        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;
            if (hasCommonLanguage(languages[u], languages[v])) {
                continue;
            }
            int count = 0;
            for (int l : languages[u]) {
                count += langCount[l] - langToUsers.get(l).size();
            }
            for (int l : languages[v]) {
                count += langCount[l] - langToUsers.get(l).size();
            }
            min = Math.min(min, count);
        }
        return min;
    }
    private boolean hasCommonLanguage(int[] a, int[] b) {
        for (int i : a) {
            for (int j : b) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }
}