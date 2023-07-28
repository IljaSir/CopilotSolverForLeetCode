class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int n = target.length();
        int m = stamp.length();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i <= n - m; i++) {
                if (!visited[i] && canChange(s, t, i)) {
                    changed = true;
                    visited[i] = true;
                    ans.add(i);
                    for (int j = i; j < i + m; j++) {
                        t[j] = '?';
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (t[i] != '?') {
                return new int[0];
            }
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(ans.size() - 1 - i);
        }
        return ret;
    }

    private boolean canChange(char[] s, char[] t, int i) {
        int m = s.length;
        for (int j = 0; j < m; j++) {
            if (t[i + j] != '?' && t[i + j] != s[j]) {
                return false;
            }
        }
        return true;
    }
}