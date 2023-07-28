class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        int m = stamp.length(), n = target.length();
        boolean[] done = new boolean[n];
        List<Integer> ans = new ArrayList();
        char[] s = stamp.toCharArray(), t = target.toCharArray();
        int changed = 0;

        while (changed < n) {
            boolean found = false;
            for (int i = 0; i <= n - m; ++i) {
                if (!done[i] && canTransform(s, t, i)) {
                    found = true;
                    done[i] = true;
                    changed += replace(t, i, m, '?');
                    ans.add(i);
                }
            }
            if (!found) return new int[0];
        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    public boolean canTransform(char[] s, char[] t, int i) {
        for (int j = 0; j < s.length; ++j)
            if (t[i+j] != '?' && t[i+j] != s[j])
                return false;
        return true;
    }

    public int replace(char[] t, int i, int m, char c) {
        int ans = 0;
        for (int j = 0; j < m; ++j)
            if (t[i+j] != '?') {
                t[i+j] = '?';
                ans++;
            }
        return ans;
    }
}